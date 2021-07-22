package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "companies_info")
@JsonDeserialize(builder = CompanyInfo.Builder.class)
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

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    protected static final class Builder {
        private final List<Consumer<CompanyInfo>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withCompany(Company company) {
            operations.add(e -> e.company = company);
            return this;
        }

        public Builder withStockExchange(StockExchange stockExchange) {
            operations.add(e -> e.stockExchange = stockExchange);
            return this;
        }

        public Builder withIndustry(Industry industry) {
            operations.add(e -> e.industry = industry);
            return this;
        }

        public Builder withActivityTags(List<ActivityTag> activityTags) {
            operations.add(e -> e.activityTags = activityTags);
            return this;
        }

        public CompanyInfo build() {
            CompanyInfo companyInfo = new CompanyInfo();
            operations.forEach(operation -> operation.accept(companyInfo));
            return companyInfo;
        }

    }

    public Long getId() {
        return id;
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
