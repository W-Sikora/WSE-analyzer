package pl.wsikora.wseanalyzer.model.statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "balance_sheets")
public class BalanceSheet extends Statement {

    @Column(name = "fixed_asset")
    private Long fixedAsset;

    @Column(name = "current_asset")
    private Long currentAsset;

    @Column(name = "total_assets")
    private Long totalAssets;

    @Column(name = "current_receivables")
    private Long currentReceivables;

    @Column(name = "current_investments")
    private Long currentInvestments;

    @Column(name = "cash_and_equivalents")
    private Long cashAndEquivalents;

    @Column(name = "shareholders_equity")
    private Long shareholdersEquity;

    @Column(name = "long_term_liabilities")
    private Long longTermLiabilities;

    @Column(name = "current_liabilities")
    private Long currentLiabilities;

    @Column(name = "total_liabilities_and_equity")
    private Long totalLiabilitiesAndEquity;

    public BalanceSheet() {
        super();
    }

    public Long getFixedAsset() {
        return fixedAsset;
    }

    public void setFixedAsset(Long fixedAsset) {
        this.fixedAsset = fixedAsset;
    }

    public Long getCurrentAsset() {
        return currentAsset;
    }

    public void setCurrentAsset(Long currentAsset) {
        this.currentAsset = currentAsset;
    }

    public Long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Long getCurrentReceivables() {
        return currentReceivables;
    }

    public void setCurrentReceivables(Long currentReceivables) {
        this.currentReceivables = currentReceivables;
    }

    public Long getCurrentInvestments() {
        return currentInvestments;
    }

    public void setCurrentInvestments(Long currentInvestments) {
        this.currentInvestments = currentInvestments;
    }

    public Long getCashAndEquivalents() {
        return cashAndEquivalents;
    }

    public void setCashAndEquivalents(Long cashAndEquivalents) {
        this.cashAndEquivalents = cashAndEquivalents;
    }

    public Long getShareholdersEquity() {
        return shareholdersEquity;
    }

    public void setShareholdersEquity(Long shareholdersEquity) {
        this.shareholdersEquity = shareholdersEquity;
    }

    public Long getLongTermLiabilities() {
        return longTermLiabilities;
    }

    public void setLongTermLiabilities(Long longTermLiabilities) {
        this.longTermLiabilities = longTermLiabilities;
    }

    public Long getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(Long currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    public Long getTotalLiabilitiesAndEquity() {
        return totalLiabilitiesAndEquity;
    }

    public void setTotalLiabilitiesAndEquity(Long totalLiabilitiesAndEquity) {
        this.totalLiabilitiesAndEquity = totalLiabilitiesAndEquity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceSheet that = (BalanceSheet) o;
        return Objects.equals(fixedAsset, that.fixedAsset) &&
                Objects.equals(currentAsset, that.currentAsset) &&
                Objects.equals(totalAssets, that.totalAssets) &&
                Objects.equals(currentReceivables, that.currentReceivables) &&
                Objects.equals(currentInvestments, that.currentInvestments) &&
                Objects.equals(cashAndEquivalents, that.cashAndEquivalents) &&
                Objects.equals(shareholdersEquity, that.shareholdersEquity) &&
                Objects.equals(longTermLiabilities, that.longTermLiabilities) &&
                Objects.equals(currentLiabilities, that.currentLiabilities) &&
                Objects.equals(totalLiabilitiesAndEquity, that.totalLiabilitiesAndEquity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fixedAsset, currentAsset, totalAssets, currentReceivables, currentInvestments, cashAndEquivalents, shareholdersEquity, longTermLiabilities, currentLiabilities, totalLiabilitiesAndEquity);
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
                "id=" + getId() +
                ", company=" + getCompany() +
                ", date=" + getDate() +
                ", fixedAsset=" + fixedAsset +
                ", currentAsset=" + currentAsset +
                ", totalAssets=" + totalAssets +
                ", currentReceivables=" + currentReceivables +
                ", currentInvestments=" + currentInvestments +
                ", cashAndEquivalents=" + cashAndEquivalents +
                ", shareholdersEquity=" + shareholdersEquity +
                ", longTermLiabilities=" + longTermLiabilities +
                ", currentLiabilities=" + currentLiabilities +
                ", totalLiabilitiesAndEquity=" + totalLiabilitiesAndEquity +
                '}';
    }

}
