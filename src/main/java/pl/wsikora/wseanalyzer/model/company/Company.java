package pl.wsikora.wseanalyzer.model.company;

import pl.wsikora.wseanalyzer.model.company.general.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.model.company.info.CompanyInfo;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String isin;

    private String ticker;

    private String businessRadarAcronym;

    private String bankerAcronym;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CompanyGeneralInfo companyGeneralInfo;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CompanyInfo companyInfo;

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getBusinessRadarAcronym() {
        return businessRadarAcronym;
    }

    public void setBusinessRadarAcronym(String businessRadarAcronym) {
        this.businessRadarAcronym = businessRadarAcronym;
    }

    public String getBankerAcronym() {
        return bankerAcronym;
    }

    public void setBankerAcronym(String bankerAcronym) {
        this.bankerAcronym = bankerAcronym;
    }

    public CompanyGeneralInfo getCompanyGeneralInfo() {
        return companyGeneralInfo;
    }

    public void setCompanyGeneralInfo(CompanyGeneralInfo companyGeneralInfo) {
        this.companyGeneralInfo = companyGeneralInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }
}
