package pl.wsikora.wseanalyzer.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Entity
@Table(name = "cash_flow_statements")
@JsonDeserialize(builder = CashFlowStatement.Builder.class)
public class CashFlowStatement extends Statement implements ModelEntity {

    @Column(name = "operating_activities")
    private Long operatingActivities;

    @Column(name = "investing_activities")
    private Long investingActivities;

    @Column(name = "financing_activities")
    private Long financingActivities;

    @Column(name = "total_cash_flow")
    private Long totalCashFlow;

    public CashFlowStatement() {
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<CashFlowStatement>> operations;

        private Builder() {
            this.operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withCompany(Company company) {
            operations.add(e -> e.company = company);
            return this;
        }

        public Builder withDate(LocalDate date) {
            operations.add(e -> e.date = date);
            return this;
        }

        public Builder withOperatingActivities(Long operatingActivities) {
            operations.add(e -> e.operatingActivities = operatingActivities);
            return this;
        }

        public Builder withInvestingActivities(Long investingActivities) {
            operations.add(e -> e.investingActivities = investingActivities);
            return this;
        }

        public Builder withFinancingActivities(Long financingActivities) {
            operations.add(e -> e.financingActivities = financingActivities);
            return this;
        }

        public Builder withTotalCashFlow(Long totalCashFlow) {
            operations.add(e -> e.totalCashFlow = totalCashFlow);
            return this;
        }

        public CashFlowStatement build() {
            CashFlowStatement cashFlowStatement = new CashFlowStatement();
            operations.forEach(operation -> operation.accept(cashFlowStatement));
            return cashFlowStatement;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public CashFlowStatement merge(CashFlowStatement cashFlowStatement) {
        return CashFlowStatement.builder()
                .withId(this.id)
                .withCompany(returnNewValueIfChanged(this.company, cashFlowStatement.company))
                .withDate(returnNewValueIfChanged(this.date, cashFlowStatement.date))
                .withOperatingActivities(returnNewValueIfChanged(this.operatingActivities, cashFlowStatement.operatingActivities))
                .withInvestingActivities(returnNewValueIfChanged(this.investingActivities, cashFlowStatement.investingActivities))
                .withFinancingActivities(returnNewValueIfChanged(this.financingActivities, cashFlowStatement.financingActivities))
                .withTotalCashFlow(returnNewValueIfChanged(this.totalCashFlow, cashFlowStatement.totalCashFlow))
                .build();
    }

    public Long getOperatingActivities() {
        return operatingActivities;
    }

    public Long getInvestingActivities() {
        return investingActivities;
    }

    public Long getFinancingActivities() {
        return financingActivities;
    }

    public Long getTotalCashFlow() {
        return totalCashFlow;
    }

    @Override
    public String toString() {
        return "CashFlowStatement{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", operatingActivities=" + operatingActivities +
                ", investingActivities=" + investingActivities +
                ", financingActivities=" + financingActivities +
                ", totalCashFlow=" + totalCashFlow +
                '}';
    }

}
