package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.company.general.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.model.company.info.CompanyInfo;
import pl.wsikora.wseanalyzer.model.company.info.Industry;
import pl.wsikora.wseanalyzer.model.company.info.StockExchange;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.time.LocalDate;
import java.util.Optional;

import static pl.wsikora.wseanalyzer.util.date.DateParser.dateFormatter;

public class CompanyCollector {
    private final Document document;
    private final Elements profileSummary;
    private final Elements profileSummary2;
    private final String businessRadarAcronym;

    public CompanyCollector(String url, String businessRadarAcronym) {
        this.document = URLDocument.get(url);
        this.profileSummary = document.select("#left-content div[class=box-left] table[class=profileSummary]");
        this.profileSummary2 = document.select("#left-content div[class=box-left] table[class=class=profileSummary hidden]");
        this.businessRadarAcronym = businessRadarAcronym;
    }

    public Company formCompany() {
        Company company = new Company();
        company.setName(document.select("#fullname-container h2").text());
        company.setTicker(document.select("#profile-header h1").text()
                .replace("Notowania ", "")
                .replaceAll("\\(.+\\)", ""));
        company.setBusinessRadarAcronym(businessRadarAcronym);
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

    private static Optional<String> extractFromProfile(Elements profileSummary, String key) {
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
