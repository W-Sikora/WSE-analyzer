package pl.wsikora.wseanalyzer.dto.company;

import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.company.general.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.model.company.info.ActivityTag;
import pl.wsikora.wseanalyzer.model.company.info.CompanyInfo;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyDTO {
    private final Long id;
    private final String name;
    private final String isin;
    private final String ticker;
    private final String industryName;
    private final String stockExchangeName;
    private final List<String> activityTags;


    public CompanyDTO(Company company) {
        CompanyInfo companyInfo = company.getCompanyInfo();
        this.id = company.getId();
        this.name = company.getName();
        this.isin = company.getIsin();
        this.ticker = company.getTicker();
        this.industryName = companyInfo.getIndustry().name();
        this.stockExchangeName = companyInfo.getStockExchange().name();
        this.activityTags = companyInfo.getActivityTags().stream().map(ActivityTag::getTagName).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsin() {
        return isin;
    }

    public String getTicker() {
        return ticker;
    }

    public String getIndustryName() {
        return industryName;
    }

    public String getStockExchangeName() {
        return stockExchangeName;
    }

    public List<String> getActivityTags() {
        return activityTags;
    }


}
