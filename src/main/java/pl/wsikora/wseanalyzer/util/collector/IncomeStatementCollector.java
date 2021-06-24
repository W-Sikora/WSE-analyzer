package pl.wsikora.wseanalyzer.util.collector;

import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.statement.IncomeStatement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.URL_PATTERN;
import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.INCOME_STATEMENT_URL;

public class IncomeStatementCollector extends StatementCollector {
    private final Company company;

    public IncomeStatementCollector(Company company) {
        super(String.format(URL_PATTERN, INCOME_STATEMENT_URL, company.getBusinessRadarAcronym()));
        this.company = company;
    }

    public List<IncomeStatement> getPart(int elementsNumber) {
        int end = size();
        int start = Math.max(end - elementsNumber, 0);
        return IntStream.range(start, end)
                .mapToObj(this::form)
                .collect(Collectors.toList());
    }

    public IncomeStatement getLatest() {
        return form(size() - 1);
    }

    public IncomeStatement get(int index) {
        return form(index);
    }

    private IncomeStatement form(int index) {
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
