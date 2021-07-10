package pl.wsikora.wseanalyzer.model.statement;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "cash_flow_statements")
public class CashFlowStatement extends Statement {

    @Column(name = "operating_activities")
    private Long operatingActivities;

    @Column(name = "investing_activities")
    private Long investingActivities;

    @Column(name = "financing_activities")
    private Long financingActivities;

    @Column(name = "total_cash_flow")
    private Long totalCashFlow;

    public CashFlowStatement() {
        super();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashFlowStatement that = (CashFlowStatement) o;
        return Objects.equals(operatingActivities, that.operatingActivities) &&
                Objects.equals(investingActivities, that.investingActivities) &&
                Objects.equals(financingActivities, that.financingActivities) &&
                Objects.equals(totalCashFlow, that.totalCashFlow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatingActivities, investingActivities, financingActivities, totalCashFlow);
    }

    @Override
    public String toString() {
        return "CashFlowStatement{" +
                "id=" + getId() +
                ", company=" + getCompany() +
                ", date=" + getDate() +
                ", operatingActivities=" + operatingActivities +
                ", investingActivities=" + investingActivities +
                ", financingActivities=" + financingActivities +
                ", totalCashFlow=" + totalCashFlow +
                '}';
    }

}
