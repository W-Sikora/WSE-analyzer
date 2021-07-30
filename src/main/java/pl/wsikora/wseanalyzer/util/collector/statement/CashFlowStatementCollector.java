package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;

public class CashFlowStatementCollector extends StatementCollector<CashFlowStatement> {
    private final Company company;
    private final static String STATEMENT_PATH = "raporty-finansowe-przeplywy-pieniezne";

    public CashFlowStatementCollector(Company company) {
        super(STATEMENT_PATH, company.getBusinessRadarAcronym());
        this.company = company;
    }

    @Override
    public CashFlowStatement formStatement(int index) {
        return CashFlowStatement.builder()
                .withCompany(company)
                .withDate(formDate(index))
                .withOperatingActivities(formValue(index, "CashflowOperatingCashflow"))
                .withInvestingActivities(formValue(index, "CashflowInvestingCashflow"))
                .withFinancingActivities(formValue(index, "CashflowFinancingCashflow"))
                .withTotalCashFlow(formValue(index, "CashflowNetCashflow"))
                .build();
    }

}
