package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;
import static pl.wsikora.wseanalyzer.util.Utils.valueChanged;

@Entity
@Table(name = "companies")
@JsonDeserialize(builder = Company.Builder.class)
public class Company {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, length = 180)
    private String name;

    @Column(unique = true, length = 30)
    private String isin;

    @Column(unique = true, length = 5)
    private String ticker;

    @JsonIgnore
    @Column(name = "business_radar_acronym", unique = true, length = 30)
    private String businessRadarAcronym;

    @JsonIgnore
    @Column(name = "banker_acronym", unique = true, length = 30)
    private String bankerAcronym;

    public Company() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<Company>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withName(String name) {
            operations.add(e -> e.name = name);
            return this;
        }

        public Builder withIsin(String isin) {
            operations.add(e -> e.isin = isin);
            return this;
        }

        public Builder withTicker(String ticker) {
            operations.add(e -> e.ticker = ticker);
            return this;
        }

        public Builder withBusinessRadarAcronym(String businessRadarAcronym) {
            operations.add(e -> e.businessRadarAcronym = businessRadarAcronym);
            return this;
        }

        public Builder withBankerAcronym(String bankerAcronym) {
            operations.add(e -> e.bankerAcronym = bankerAcronym);
            return this;
        }

        public Company build() {
            Company company = new Company();
            operations.forEach(operation -> operation.accept(company));
            return company;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public Company merge(Company company) {
        return Company.builder()
                .withId(this.id)
                .withName(valueChanged(this.name, company.name))
                .withIsin(valueChanged(this.isin, company.isin))
                .withTicker(valueChanged(this.ticker, company.ticker))
                .withBusinessRadarAcronym(valueChanged(this.businessRadarAcronym, company.businessRadarAcronym))
                .withBankerAcronym(valueChanged(this.bankerAcronym, company.bankerAcronym))
                .build();
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

    public String getBusinessRadarAcronym() {
        return businessRadarAcronym;
    }

    public String getBankerAcronym() {
        return bankerAcronym;
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
                Objects.equals(bankerAcronym, company.bankerAcronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isin, ticker, businessRadarAcronym, bankerAcronym);
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
                '}';
    }

}
