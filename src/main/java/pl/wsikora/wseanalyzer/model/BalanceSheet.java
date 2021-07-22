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

import static pl.wsikora.wseanalyzer.util.Utils.valueChanged;

@Entity
@Table(name = "balance_sheets")
@JsonDeserialize(builder = BalanceSheet.Builder.class)
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
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private final List<Consumer<BalanceSheet>> operations;

        private Builder() {
            operations = new ArrayList<>();
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

        public Builder withFixedAsset(Long fixedAsset) {
            operations.add(e -> e.fixedAsset = fixedAsset);
            return this;
        }

        public Builder withCurrentAsset(Long currentAsset) {
            operations.add(e -> e.currentAsset = currentAsset);
            return this;
        }

        public Builder withTotalAssets(Long totalAssets) {
            operations.add(e -> e.totalAssets = totalAssets);
            return this;
        }

        public Builder withCurrentReceivables(Long currentReceivables) {
            operations.add(e -> e.currentReceivables = currentReceivables);
            return this;
        }

        public Builder withCurrentInvestments(Long currentInvestments) {
            operations.add(e -> e.currentInvestments = currentInvestments);
            return this;
        }

        public Builder withCashAndEquivalents(Long cashAndEquivalents) {
            operations.add(e -> e.cashAndEquivalents = cashAndEquivalents);
            return this;
        }

        public Builder withShareholdersEquity(Long shareholdersEquity) {
            operations.add(e -> e.shareholdersEquity = shareholdersEquity);
            return this;
        }

        public Builder withLongTermLiabilities(Long longTermLiabilities) {
            operations.add(e -> e.longTermLiabilities = longTermLiabilities);
            return this;
        }

        public Builder withCurrentLiabilities(Long currentLiabilities) {
            operations.add(e -> e.currentLiabilities = currentLiabilities);
            return this;
        }

        public Builder withTotalLiabilitiesAndEquity(Long totalLiabilitiesAndEquity) {
            operations.add(e -> e.totalLiabilitiesAndEquity = totalLiabilitiesAndEquity);
            return this;
        }

        public BalanceSheet build() {
            BalanceSheet balanceSheet = new BalanceSheet();
            operations.forEach(operation -> operation.accept(balanceSheet));
            return balanceSheet;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public BalanceSheet merge(BalanceSheet balanceSheet) {
        return BalanceSheet.builder()
                .withId(this.id)
                .withCompany(valueChanged(this.company, balanceSheet.company))
                .withDate(valueChanged(this.date, balanceSheet.date))
                .withFixedAsset(valueChanged(this.fixedAsset, balanceSheet.fixedAsset))
                .withCurrentAsset(valueChanged(this.currentAsset, balanceSheet.currentAsset))
                .withTotalAssets(valueChanged(this.totalAssets, balanceSheet.totalAssets))
                .withCurrentReceivables(valueChanged(this.currentReceivables, balanceSheet.currentReceivables))
                .withCurrentInvestments(valueChanged(this.currentInvestments, balanceSheet.currentInvestments))
                .withCashAndEquivalents(valueChanged(this.cashAndEquivalents, balanceSheet.cashAndEquivalents))
                .withShareholdersEquity(valueChanged(this.shareholdersEquity, balanceSheet.shareholdersEquity))
                .withLongTermLiabilities(valueChanged(this.longTermLiabilities, balanceSheet.longTermLiabilities))
                .withCurrentLiabilities(valueChanged(this.currentLiabilities, balanceSheet.currentLiabilities))
                .withTotalLiabilitiesAndEquity(valueChanged(this.totalLiabilitiesAndEquity, balanceSheet.totalLiabilitiesAndEquity))
                .build();
    }

    public Long getFixedAsset() {
        return fixedAsset;
    }

    public Long getCurrentAsset() {
        return currentAsset;
    }

    public Long getTotalAssets() {
        return totalAssets;
    }

    public Long getCurrentReceivables() {
        return currentReceivables;
    }

    public Long getCurrentInvestments() {
        return currentInvestments;
    }

    public Long getCashAndEquivalents() {
        return cashAndEquivalents;
    }

    public Long getShareholdersEquity() {
        return shareholdersEquity;
    }

    public Long getLongTermLiabilities() {
        return longTermLiabilities;
    }

    public Long getCurrentLiabilities() {
        return currentLiabilities;
    }

    public Long getTotalLiabilitiesAndEquity() {
        return totalLiabilitiesAndEquity;
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
                "id=" + id +
                ", company=" + company +
                ", date=" + date +
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
