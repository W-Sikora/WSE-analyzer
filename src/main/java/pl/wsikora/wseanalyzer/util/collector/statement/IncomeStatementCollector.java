package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.model.IncomeStatement;

public class IncomeStatementCollector extends StatementCollector<IncomeStatement> {
    private final Company company;
    private final static String STATEMENT_PATH = "raporty-finansowe-rachunek-zyskow-i-strat";

    public IncomeStatementCollector(Company company) {
        super(STATEMENT_PATH, company.getBusinessRadarAcronym());
        this.company = company;

    }

    @Override
    public IncomeStatement formStatement(int index) {
        return IncomeStatement.builder()
                .withCompany(company)
                .withDate(formDate(index))
                .withRevenue(formValue(index, "IncomeRevenues"))
                .withGoodsSoldCosts(formValue(index, "IncomeCostOfSales"))
                .withSellingCosts(formValue(index, "IncomeDistributionExpenses"))
                .withAdministrativeCosts(formValue(index, "IncomeAdministrativExpenses"))
                .withProfit(formValue(index, "IncomeGrossProfit"))
                .withOperatingIncome(formValue(index, "IncomeEBIT"))
                .withIncomeBeforeTaxes(formValue(index, "IncomeBeforeTaxProfit"))
                .withNetIncome(formValue(index, "IncomeNetProfit"))
                .build();
    }

}
