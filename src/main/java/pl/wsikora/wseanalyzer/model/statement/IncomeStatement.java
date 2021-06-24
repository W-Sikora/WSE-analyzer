package pl.wsikora.wseanalyzer.model.statement;

import pl.wsikora.wseanalyzer.model.company.Company;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "income_statements")
public class IncomeStatement extends Statement {

    private Long revenue;

    private Long goodsSoldCosts;

    private Long sellingCosts;

    private Long administrativeCosts;

    private Long profit;

    private Long operatingIncome;

    private Long incomeBeforeTaxes;

    private Long netIncome;

    public IncomeStatement() {
        super();
    }

    public IncomeStatement(Company company, LocalDate date, Long revenue, Long goodsSoldCosts, Long sellingCosts, Long administrativeCosts, Long profit, Long operatingIncome, Long incomeBeforeTaxes, Long netIncome) {
        super(company, date);
        this.revenue = revenue;
        this.goodsSoldCosts = goodsSoldCosts;
        this.sellingCosts = sellingCosts;
        this.administrativeCosts = administrativeCosts;
        this.profit = profit;
        this.operatingIncome = operatingIncome;
        this.incomeBeforeTaxes = incomeBeforeTaxes;
        this.netIncome = netIncome;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Long getGoodsSoldCosts() {
        return goodsSoldCosts;
    }

    public void setGoodsSoldCosts(Long goodsSoldCosts) {
        this.goodsSoldCosts = goodsSoldCosts;
    }

    public Long getSellingCosts() {
        return sellingCosts;
    }

    public void setSellingCosts(Long sellingCosts) {
        this.sellingCosts = sellingCosts;
    }

    public Long getAdministrativeCosts() {
        return administrativeCosts;
    }

    public void setAdministrativeCosts(Long administrativeCosts) {
        this.administrativeCosts = administrativeCosts;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public Long getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(Long operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public Long getIncomeBeforeTaxes() {
        return incomeBeforeTaxes;
    }

    public void setIncomeBeforeTaxes(Long incomeBeforeTaxes) {
        this.incomeBeforeTaxes = incomeBeforeTaxes;
    }

    public Long getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Long netIncome) {
        this.netIncome = netIncome;
    }



    @Override
    public String toString() {
        return "IncomeStatement{" +
                "id=" + getId() +
                ", company=" + getCompany() +
                ", date=" + getDate() +
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
