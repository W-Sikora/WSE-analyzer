package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies_info")
public class CompanyInfo extends EntityClass {

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

    public Company getCompany() {
        return company;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public Industry getIndustry() {
        return industry;
    }

    public List<ActivityTag> getActivityTags() {
        return activityTags;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public void setActivityTags(List<ActivityTag> activityTags) {
        this.activityTags = activityTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyInfo that = (CompanyInfo) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                stockExchange == that.stockExchange &&
                industry == that.industry &&
                Objects.equals(activityTags, that.activityTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, stockExchange, industry, activityTags);
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + getId() +
                ", company=" + company +
                ", stockExchange=" + stockExchange +
                ", industry=" + industry +
                ", activityTags=" + activityTags +
                '}';
    }

}
