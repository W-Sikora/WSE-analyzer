package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "dividends")
public class Dividend extends EntityClass {

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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDividendPerShare(BigDecimal dividendPerShare) {
        this.dividendPerShare = dividendPerShare;
    }

    public void setDividendValue(Long dividendValue) {
        this.dividendValue = dividendValue;
    }

    public void setSupplementaryCapitalContribution(Long supplementaryCapitalContribution) {
        this.supplementaryCapitalContribution = supplementaryCapitalContribution;
    }

    public void setExDate(LocalDate exDate) {
        this.exDate = exDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dividend that = (Dividend) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(company, that.company) &&
                Objects.equals(dividendPerShare, that.dividendPerShare) &&
                Objects.equals(dividendValue, that.dividendValue) &&
                Objects.equals(supplementaryCapitalContribution, that.supplementaryCapitalContribution) &&
                Objects.equals(exDate, that.exDate) &&
                Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), company, dividendPerShare, dividendValue, supplementaryCapitalContribution, exDate, paymentDate);
    }

    @Override
    public String toString() {
        return "Dividend{" +
                "id=" + getId() +
                ", company=" + company +
                ", dividendPerShare=" + dividendPerShare +
                ", dividendValue=" + dividendValue +
                ", supplementaryCapitalContribution=" + supplementaryCapitalContribution +
                ", exDate=" + exDate +
                ", paymentDate=" + paymentDate +
                '}';
    }

}
