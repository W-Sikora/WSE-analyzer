package pl.wsikora.wseanalyzer.util.collector;

import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.statement.IncomeStatement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IncomeStatementCollector extends StatementCollector {
    private final Company company;

    public IncomeStatementCollector(Company company) {
        super(" ");
        this.company = company;
    }

    public List<IncomeStatement> getAll() {
        return IntStream.range(0, 1)
                .mapToObj(this::form)
                .collect(Collectors.toList());
    }

    public IncomeStatement getLatest() {
        return form(9);
    }

    public IncomeStatement get(int index) {
        return form(index);
    }


    private IncomeStatement form(int index) {
        IncomeStatement statement = new IncomeStatement();
        statement.setCompany(company);
        setDateA(index, statement::setDate);
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
