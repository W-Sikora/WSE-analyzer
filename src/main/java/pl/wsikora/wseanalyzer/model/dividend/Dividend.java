package pl.wsikora.wseanalyzer.model.dividend;


import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    private BigDecimal dividendPerShare;

    private Long dividendValue;

    private Long supplementaryCapitalContribution;

    private LocalDate exDate;

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
}
