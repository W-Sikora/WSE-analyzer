package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.statement.CashFlowStatement;

import static pl.wsikora.wseanalyzer.util.collector.statement.StatementCollectorValues.*;

public class CashFlowStatementCollector extends StatementCollector {
    private final Company company;

    public CashFlowStatementCollector(Company company) {
        super(String.format(URL_PATTERN, CASH_FLOW_STATEMENT_URL, company.getBusinessRadarAcronym(), "Q"));
        this.company = company;
    }

    @Override
    public CashFlowStatement form(int index) {
        CashFlowStatement cashFlowStatement = new CashFlowStatement();
        cashFlowStatement.setCompany(company);
        setDate(index, cashFlowStatement::setDate);
        setSingleValue("CashflowOperatingCashflow", index, cashFlowStatement::setOperatingActivities);
        setSingleValue("CashflowInvestingCashflow", index, cashFlowStatement::setInvestingActivities);
        setSingleValue("CashflowFinancingCashflow", index, cashFlowStatement::setFinancingActivities);
        setSingleValue("CashflowNetCashflow", index, cashFlowStatement::setTotalCashFlow);
        return cashFlowStatement;
    }


}
