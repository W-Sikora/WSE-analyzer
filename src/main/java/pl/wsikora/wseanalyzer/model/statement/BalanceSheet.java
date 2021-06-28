package pl.wsikora.wseanalyzer.model.statement;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "balance_sheets")
public class BalanceSheet extends Statement {

    private Long fixedAsset;

    private Long currentAsset;

    private Long totalAssets;

    private Long currentReceivables;

    private Long currentInvestments;

    private Long cashAndEquivalents;

    private Long shareholdersEquity;

    private Long longTermLiabilities;

    private Long currentLiabilities;

    private Long totalLiabilitiesAndEquity;


    public BalanceSheet() {
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
    public String toString() {
        return "BalanceSheet{" +
                "fixedAsset=" + fixedAsset +
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
