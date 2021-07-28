package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.model.BalanceSheet;

import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.*;

public class BalanceSheetCollector extends StatementCollector <BalanceSheet> {
    private final Company company;

    public BalanceSheetCollector(Company company) {
        super(String.format(URL_PATTERN, BALANCE_SHEET_URL, company.getBusinessRadarAcronym(), "Q,0"));
        this.company = company;
    }

    @Override
    public BalanceSheet form(int index) {


        BalanceSheet balanceSheet = new BalanceSheet();
//        balanceSheet.setCompany(company);
//        setDate(index, balanceSheet::setDate);
//        setSingleValue("BalanceNoncurrentAssets", index, balanceSheet::setFixedAsset);
//        setSingleValue("BalanceCurrentAssets", index, balanceSheet::setCurrentAsset);
//        setSingleValue("BalanceTotalAssets", index, balanceSheet::setTotalAssets);
//        setSingleValue("BalanceCurrentReceivables", index, balanceSheet::setCurrentReceivables);
//        setSingleValue("BalanceCurrentInvestments", index, balanceSheet::setCurrentInvestments);
//        setSingleValue("BalanceCash", index, balanceSheet::setCashAndEquivalents);
//        setSingleValue("BalanceCapital", index, balanceSheet::setShareholdersEquity);
//        setSingleValue("BalanceNoncurrentLiabilities", index, balanceSheet::setLongTermLiabilities);
//        setSingleValue("BalanceCurrentLiabilities", index, balanceSheet::setCurrentLiabilities);
//        setSingleValue("BalanceTotalEquityAndLiabilities", index, balanceSheet::setTotalLiabilitiesAndEquity);
        return balanceSheet;
    }


}
