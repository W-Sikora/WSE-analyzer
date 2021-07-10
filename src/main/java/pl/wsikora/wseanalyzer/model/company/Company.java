package pl.wsikora.wseanalyzer.model.company;

import pl.wsikora.wseanalyzer.model.company.general.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.model.company.info.CompanyInfo;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true,
            length = 180)
    private String name;

    @Column(unique = true,
            length = 30)
    private String isin;

    @Column(unique = true,
            length = 5)
    private String ticker;

    @Column(name = "business_radar_acronym",
            unique = true,
            length = 30)
    private String businessRadarAcronym;

    @Column(name = "banker_acronym",
            unique = true,
            length = 30)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(isin, company.isin) &&
                Objects.equals(ticker, company.ticker) &&
                Objects.equals(businessRadarAcronym, company.businessRadarAcronym) &&
                Objects.equals(bankerAcronym, company.bankerAcronym) &&
                Objects.equals(companyGeneralInfo, company.companyGeneralInfo) &&
                Objects.equals(companyInfo, company.companyInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isin, ticker, businessRadarAcronym, bankerAcronym, companyGeneralInfo, companyInfo);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", ticker='" + ticker + '\'' +
                ", businessRadarAcronym='" + businessRadarAcronym + '\'' +
                ", bankerAcronym='" + bankerAcronym + '\'' +
                ", companyGeneralInfo=" + companyGeneralInfo +
                ", companyInfo=" + companyInfo +
                '}';
    }

}
