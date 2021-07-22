package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Entity
@Table(name = "income_statements")
@JsonDeserialize(builder = IncomeStatement.Builder.class)
public final class IncomeStatement extends Statement {

    private Long revenue;

    @Column(name = "goods_sold_costs")
    private Long goodsSoldCosts;

    @Column(name = "selling_costs")
    private Long sellingCosts;

    @Column(name = "administrative_costs")
    private Long administrativeCosts;

    private Long profit;

    @Column(name = "operating_income")
    private Long operatingIncome;

    @Column(name = "income_before_taxes")
    private Long incomeBeforeTaxes;

    @Column(name = "net_income")
    private Long netIncome;

    public IncomeStatement() {
    }

    public Builder builder() {
        return new Builder();
    }

    static final class Builder {
        private final List<Consumer<IncomeStatement>> operations;

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

        public Builder withRevenue(Long revenue) {
            operations.add(e -> e.revenue = revenue);
            return this;
        }

        public Builder withGoodsSoldCosts(Long goodsSoldCosts) {
            operations.add(e -> e.goodsSoldCosts = goodsSoldCosts);
            return this;
        }

        public Builder withSellingCosts(Long sellingCosts) {
            operations.add(e -> e.sellingCosts = sellingCosts);
            return this;
        }

        public Builder withAdministrativeCosts(Long administrativeCosts) {
            operations.add(e -> e.administrativeCosts = administrativeCosts);
            return this;
        }

        public Builder withProfit(Long profit) {
            operations.add(e -> e.profit = profit);
            return this;
        }

        public Builder withOperatingIncome(Long operatingIncome) {
            operations.add(e -> e.operatingIncome = operatingIncome);
            return this;
        }

        public Builder withIncomeBeforeTaxes(Long incomeBeforeTaxes) {
            operations.add(e -> e.incomeBeforeTaxes = incomeBeforeTaxes);
            return this;
        }

        public Builder withNetIncome(Long netIncome) {
            operations.add(e -> e.netIncome = netIncome);
            return this;
        }

        public IncomeStatement build() {
            IncomeStatement incomeStatement = new IncomeStatement();
            operations.forEach(operation -> operation.accept(incomeStatement));
            return incomeStatement;
        }

    }

    public Long getRevenue() {
        return revenue;
    }

    public Long getGoodsSoldCosts() {
        return goodsSoldCosts;
    }

    public Long getSellingCosts() {
        return sellingCosts;
    }

    public Long getAdministrativeCosts() {
        return administrativeCosts;
    }

    public Long getProfit() {
        return profit;
    }

    public Long getOperatingIncome() {
        return operatingIncome;
    }

    public Long getIncomeBeforeTaxes() {
        return incomeBeforeTaxes;
    }

    public Long getNetIncome() {
        return netIncome;
    }

    @Override
    public String toString() {
        return "IncomeStatement{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
                ", revenue=" + revenue +
                ", goodsSoldCosts=" + goodsSoldCosts +
                ", sellingCosts=" + sellingCosts +
                ", administrativeCosts=" + administrativeCosts +
                ", profit=" + profit +
                ", operatingIncome=" + operatingIncome +
                ", incomeBeforeTaxes=" + incomeBeforeTaxes +
                ", netIncome=" + netIncome +
                '}';
    }

}
