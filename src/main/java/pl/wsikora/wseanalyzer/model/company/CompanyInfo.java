package pl.wsikora.wseanalyzer.model.company;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies_info")
public class CompanyInfo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "stock_exchange")
    private StockExchange stockExchange;

    private Industry industry;

    @ManyToMany
    @JoinTable(name = "companies_activity_tags")
    private List<ActivityTag> activityTags;

    public CompanyInfo() {
    }

    public CompanyInfo(Company company, StockExchange stockExchange, Industry industry, List<ActivityTag> activityTags) {
        this.company = company;
        this.stockExchange = stockExchange;
        this.industry = industry;
        this.activityTags = activityTags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public List<ActivityTag> getActivityTags() {
        return activityTags;
    }

    public void setActivityTags(List<ActivityTag> activityTags) {
        this.activityTags = activityTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyInfo that = (CompanyInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                stockExchange == that.stockExchange &&
                industry == that.industry &&
                Objects.equals(activityTags, that.activityTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, stockExchange, industry, activityTags);
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", company=" + company +
                ", stockExchange=" + stockExchange +
                ", industry=" + industry +
                ", activityTags=" + activityTags +
                '}';
    }

}
