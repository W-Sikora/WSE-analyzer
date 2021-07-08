package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.statement.IncomeStatement;

import static pl.wsikora.wseanalyzer.util.collector.statement.StatementCollectorValues.URL_PATTERN;
import static pl.wsikora.wseanalyzer.util.collector.statement.StatementCollectorValues.INCOME_STATEMENT_URL;

public class IncomeStatementCollector extends StatementCollector {
    private final Company company;

    public IncomeStatementCollector(Company company) {
        super(String.format(URL_PATTERN, INCOME_STATEMENT_URL, company.getBusinessRadarAcronym(), "Q"));
        this.company = company;
    }

    @Override
    public IncomeStatement form(int index) {
        IncomeStatement statement = new IncomeStatement();
        statement.setCompany(company);
        setDate(index, statement::setDate);
        setSingleValue("IncomeRevenues", index, statement::setRevenue);
        setSingleValue("IncomeCostOfSales", index, statement::setGoodsSoldCosts);
        setSingleValue("IncomeDistributionExpenses", index, statement::setSellingCosts);
        setSingleValue("IncomeAdministrativExpenses", index, statement::setAdministrativeCosts);
        setSingleValue("IncomeGrossProfit", index, statement::setProfit);
        setSingleValue("IncomeEBIT", index, statement::setOperatingIncome);
        setSingleValue("IncomeBeforeTaxProfit", index, statement::setIncomeBeforeTaxes);
        setSingleValue("IncomeNetProfit", index, statement::setNetIncome);
        return statement;
    }

}
