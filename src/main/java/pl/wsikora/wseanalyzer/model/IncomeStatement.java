package pl.wsikora.wseanalyzer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "income_statements")
public class IncomeStatement extends Statement {

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

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public void setGoodsSoldCosts(Long goodsSoldCosts) {
        this.goodsSoldCosts = goodsSoldCosts;
    }

    public void setSellingCosts(Long sellingCosts) {
        this.sellingCosts = sellingCosts;
    }

    public void setAdministrativeCosts(Long administrativeCosts) {
        this.administrativeCosts = administrativeCosts;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public void setOperatingIncome(Long operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public void setIncomeBeforeTaxes(Long incomeBeforeTaxes) {
        this.incomeBeforeTaxes = incomeBeforeTaxes;
    }

    public void setNetIncome(Long netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeStatement that = (IncomeStatement) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(revenue, that.revenue) &&
                Objects.equals(goodsSoldCosts, that.goodsSoldCosts) &&
                Objects.equals(sellingCosts, that.sellingCosts) &&
                Objects.equals(administrativeCosts, that.administrativeCosts) &&
                Objects.equals(profit, that.profit) &&
                Objects.equals(operatingIncome, that.operatingIncome) &&
                Objects.equals(incomeBeforeTaxes, that.incomeBeforeTaxes) &&
                Objects.equals(netIncome, that.netIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCompany(), getDate(), revenue, goodsSoldCosts, sellingCosts, administrativeCosts, profit, operatingIncome, incomeBeforeTaxes, netIncome);
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
