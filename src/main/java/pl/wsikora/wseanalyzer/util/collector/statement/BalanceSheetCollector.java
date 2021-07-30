package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.model.BalanceSheet;

public class BalanceSheetCollector extends StatementCollector<BalanceSheet> {
    private final Company company;
    private final static String STATEMENT_PATH = "raporty-finansowe-bilans";

    public BalanceSheetCollector(Company company) {
        super(STATEMENT_PATH, company.getBusinessRadarAcronym());
        this.company = company;
    }

    @Override
    public BalanceSheet formStatement(int index) {
        return BalanceSheet.builder()
                .withCompany(company)
                .withDate(formDate(index))
                .withFixedAsset(formValue(index, "BalanceNoncurrentAssets"))
                .withCurrentAsset(formValue(index, "BalanceCurrentAssets"))
                .withTotalAssets(formValue(index, "BalanceTotalAssets"))
                .withCurrentReceivables(formValue(index, "BalanceCurrentReceivables"))
                .withCurrentInvestments(formValue(index, "BalanceCurrentInvestments"))
                .withCashAndEquivalents(formValue(index, "BalanceCash"))
                .withShareholdersEquity(formValue(index, "BalanceCapital"))
                .withLongTermLiabilities(formValue(index, "BalanceNoncurrentLiabilities"))
                .withCurrentLiabilities(formValue(index, "BalanceCurrentLiabilities"))
                .withTotalLiabilitiesAndEquity(formValue(index, "BalanceTotalEquityAndLiabilities"))
                .build();
    }

}
