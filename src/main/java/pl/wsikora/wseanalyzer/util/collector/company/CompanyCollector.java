package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.wsikora.wseanalyzer.model.company.*;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.time.LocalDate;
import java.util.Optional;

import static pl.wsikora.wseanalyzer.util.date.DateParser.dateFormatter;
import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.COMPANY_PAGE_URL;
import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.PROFILE_SUMMARY_CSS_QUERY;

public class CompanyCollector {
    private final Document document;
    private final Element profileSummary;
    private final Element profileSummary2;
    private final String businessRadarAcronym;
//    private final Map<String, String> bankerAcronyms;

    public CompanyCollector(String businessRadarAcronym) {
        this.document = URLDocument.get(String.format(COMPANY_PAGE_URL, businessRadarAcronym));
        this.profileSummary = document.select(PROFILE_SUMMARY_CSS_QUERY).get(0);
        this.profileSummary2 = document.select(PROFILE_SUMMARY_CSS_QUERY).get(1);
        this.businessRadarAcronym = businessRadarAcronym;
//        this.bankerAcronyms = BankerInfoCollector.getTickersWithBankerAcronym();
    }

    public Company formCompany() {
        Company company = new Company();
        company.setName(document.select("#fullname-container h2").text());
        company.setTicker(document.select("#profile-header h1").text()
                .replace("Notowania ", "")
                .replaceAll("\\(.+\\)", "")
                .strip());
        company.setBusinessRadarAcronym(businessRadarAcronym);
//        company.setBankerAcronym(bankerAcronyms.get(company.getTicker()));
        extractFromProfile(profileSummary,"ISIN")
                .ifPresent(company::setIsin);
        return company;
    }

    public CompanyGeneralInfo formCompanyGeneralInfo() {
        CompanyGeneralInfo companyGeneralInfo = new CompanyGeneralInfo();
        extractFromProfile(profileSummary, "Data debiutu")
                .ifPresent(e -> companyGeneralInfo.setDebutDate(LocalDate.parse(e, dateFormatter)));
        extractFromProfile(profileSummary,"Liczba akcji")
                .ifPresent(e -> companyGeneralInfo.setSharesNumber(Long.parseLong(e.replaceAll("\\s", ""))));
        extractFromProfile(profileSummary2, "Adres")
                .ifPresent(companyGeneralInfo::setLocation);
        extractFromProfile(profileSummary2, "CEO")
                .ifPresent(companyGeneralInfo::setCeo);
        return companyGeneralInfo;
    }

    public CompanyInfo formCompanyInfo() {
        CompanyInfo companyInfo = new CompanyInfo();
        extractFromProfile(profileSummary, "Sektor")
                .ifPresent(e -> {
                    if (e.contains("GPW")) {
                        companyInfo.setStockExchange(StockExchange.WSE);
                    } else {
                        companyInfo.setStockExchange(StockExchange.NEW_CONNECT);
                    }
                });
        extractFromProfile(profileSummary, "Branża")
                .ifPresent(e -> {
                    for(Industry industry : Industry.values()) {
                        if (industry.getName().equals(e)) {
                            companyInfo.setIndustry(industry);
                        }
                    }
                });
        return companyInfo;
    }

    private static Optional<String> extractFromProfile(Element profileSummary, String key) {
        for(Element element : profileSummary.select("tr")) {
            if (isKeyLike(element, key)) {
                return Optional.of(element.select("td").text());
            }
        }
        return Optional.empty();
    }

    private static boolean isKeyLike(Element element, String key) {
        return element.select("th")
                .text()
                .contains(key);
    }

}
