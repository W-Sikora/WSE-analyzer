package pl.wsikora.wseanalyzer.model.statement;

import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cash_flow_statements")
public class CashFlowStatement extends Statement {

    private Long operatingActivities;

    private Long investingActivities;

    private Long financingActivities;

    private Long totalCashFlow;

    public CashFlowStatement() {
        super();
    }

    public CashFlowStatement(Company company, LocalDate date, Long operatingActivities, Long investingActivities, Long financingActivities, Long totalCashFlow) {
        super(company, date);
        this.operatingActivities = operatingActivities;
        this.investingActivities = investingActivities;
        this.financingActivities = financingActivities;
        this.totalCashFlow = totalCashFlow;
    }

    public Long getOperatingActivities() {
        return operatingActivities;
    }

    public void setOperatingActivities(Long operatingActivities) {
        this.operatingActivities = operatingActivities;
    }

    public Long getInvestingActivities() {
        return investingActivities;
    }

    public void setInvestingActivities(Long investingActivities) {
        this.investingActivities = investingActivities;
    }

    public Long getFinancingActivities() {
        return financingActivities;
    }

    public void setFinancingActivities(Long financingActivities) {
        this.financingActivities = financingActivities;
    }

    public Long getTotalCashFlow() {
        return totalCashFlow;
    }

    public void setTotalCashFlow(Long totalCashFlow) {
        this.totalCashFlow = totalCashFlow;
    }
}
