package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.company.general.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.model.company.info.CompanyInfo;
import pl.wsikora.wseanalyzer.model.company.info.Industry;
import pl.wsikora.wseanalyzer.model.company.info.StockExchange;
import pl.wsikora.wseanalyzer.util.collector.Utils;

import java.time.LocalDate;


public class CompanyCollector {
    private final Document document;
    private final Elements profileSummary;

    private final String name;
    private final String ticker;
    private final String businessRadarAcronym;
    private final String isin;
    private final LocalDate debut;
    private final Long sharesNumber;
    private final String location;
    private final String ceo;
    private final String stockExchangeName;
    private final String industryName;




    public CompanyCollector(String url, String businessRadarAcronym) {
        this.document = Utils.getDocument(url);
        this.profileSummary = document.select("#left-content div[class=box-left] table[class=profileSummary]");
        this.name = document.select("#fullname-container h2").text();
        this.ticker = document.select("#profile-header h1").text()
                .replace("Notowania ", "")
                .replaceAll("\\(.+\\)", "");
        this.businessRadarAcronym = businessRadarAcronym;
        this.isin = "";
        this.debut = LocalDate.now();
        this.sharesNumber = 0L;
        this.location = "";
        this.ceo = "";
        this.stockExchangeName = "";
        this.industryName = "";
    }


    public Company formCompany() {
        Company company = new Company();

        return company;
    }

    public CompanyGeneralInfo formCompanyGeneralInfo() {
        CompanyGeneralInfo companyGeneralInfo = new CompanyGeneralInfo();
        companyGeneralInfo.setDebutDate(debut);
        companyGeneralInfo.setSharesNumber(sharesNumber);
        companyGeneralInfo.setLocation(location);
        companyGeneralInfo.setCeo(ceo);
        return companyGeneralInfo;
    }

    public CompanyInfo formCompanyInfo() {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setStockExchange(stockExchangeName.equals("GPW") ? StockExchange.WSE : StockExchange.NEW_CONNECT);
//        companyInfo.setIndustry();
        return companyInfo;
    }

    private String extractValue(String cssQuery) {
        throw new IllegalArgumentException("not implemented yet");
    }
}
