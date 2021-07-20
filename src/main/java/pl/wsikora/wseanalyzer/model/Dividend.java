package pl.wsikora.wseanalyzer.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "dividends")
public class Dividend {

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

    public BigDecimal getDividendPerShare() {
        return dividendPerShare;
    }

    public void setDividendPerShare(BigDecimal dividendPerShare) {
        this.dividendPerShare = dividendPerShare;
    }

    public Long getDividendValue() {
        return dividendValue;
    }

    public void setDividendValue(Long dividendValue) {
        this.dividendValue = dividendValue;
    }

    public Long getSupplementaryCapitalContribution() {
        return supplementaryCapitalContribution;
    }

    public void setSupplementaryCapitalContribution(Long supplementaryCapitalContribution) {
        this.supplementaryCapitalContribution = supplementaryCapitalContribution;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public void setExDate(LocalDate exDate) {
        this.exDate = exDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
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
