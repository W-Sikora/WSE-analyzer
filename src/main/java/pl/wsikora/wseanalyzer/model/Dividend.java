package pl.wsikora.wseanalyzer.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dividends")
@JsonDeserialize(builder = Dividend.Builder.class)
public final class Dividend {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "dividend_per_share")
    private BigDecimal dividendPerShare;

    @Column(name = "dividend_value")
    private Long dividendValue;

    @Column(name = "supplementary_capital_contribution")
    private Long supplementaryCapitalContribution;

    @Column(name = "ex_date")
    private LocalDate exDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    public Dividend() {
    }
    
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    protected static final class Builder {
        private final List<Consumer<Dividend>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withCompany(Company company) {
            operations.add(e -> e.company = company);
            return this;
        }

        public Builder withDividendPerShare(BigDecimal dividendPerShare) {
            operations.add(e -> e.dividendPerShare = dividendPerShare);
            return this;
        }

        public Builder withDividendValue(Long dividendValue) {
            operations.add(e -> e.dividendValue = dividendValue);
            return this;
        }

        public Builder withSupplementaryCapitalContribution(Long supplementaryCapitalContribution) {
            operations.add(e -> e.supplementaryCapitalContribution = supplementaryCapitalContribution);
            return this;
        }

        public Builder withExDate(LocalDate exDate) {
            operations.add(e -> e.exDate = exDate);
            return this;
        }

        public Builder withPaymentDate(LocalDate paymentDate) {
            operations.add(e -> e.paymentDate = paymentDate);
            return this;
        }

        public Dividend build() {
            Dividend dividend = new Dividend();
            operations.forEach(operation -> operation.accept(dividend));
            return dividend;
        }

    }
    
    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public BigDecimal getDividendPerShare() {
        return dividendPerShare;
    }

    public Long getDividendValue() {
        return dividendValue;
    }

    public Long getSupplementaryCapitalContribution() {
        return supplementaryCapitalContribution;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dividend dividend = (Dividend) o;
        return Objects.equals(id, dividend.id) &&
                Objects.equals(company, dividend.company) &&
                Objects.equals(dividendPerShare, dividend.dividendPerShare) &&
                Objects.equals(dividendValue, dividend.dividendValue) &&
                Objects.equals(supplementaryCapitalContribution, dividend.supplementaryCapitalContribution) &&
                Objects.equals(exDate, dividend.exDate) &&
                Objects.equals(paymentDate, dividend.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, dividendPerShare, dividendValue, supplementaryCapitalContribution, exDate, paymentDate);
    }

    @Override
    public String toString() {
        return "Dividend{" +
                "id=" + id +
                ", company=" + company +
                ", dividendPerShare=" + dividendPerShare +
                ", dividendValue=" + dividendValue +
                ", supplementaryCapitalContribution=" + supplementaryCapitalContribution +
                ", exDate=" + exDate +
                ", paymentDate=" + paymentDate +
                '}';
    }

}
