package pl.wsikora.wseanalyzer.util.collector.statement;

import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.model.statement.BalanceSheet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.wsikora.wseanalyzer.util.collector.statement.CollectorValues.*;

public class BalanceSheetCollector extends StatementCollector {
    private final Company company;

    public BalanceSheetCollector(Company company) {
        super(String.format(URL_PATTERN, BALANCE_SHEET_URL, company.getBusinessRadarAcronym(), "Q,0"));
        this.company = company;
    }

    protected BalanceSheet form(int index) {
        BalanceSheet balanceSheet = new BalanceSheet();
        balanceSheet.setCompany(company);
        setDate(index, balanceSheet::setDate);
//        setSingleValue("", index, balanceSheet::);
        return balanceSheet;
    }

    @Override
    public List<BalanceSheet> getPart(int elementsNumber) {
        int end = size();
        int start = Math.max(end - elementsNumber, 0);
        return IntStream.range(start, end)
                .mapToObj(this::form)
                .collect(Collectors.toList());
    }

}
