package pl.wsikora.wseanalyzer.util.collector.statement;

public class StatementCollectorValues {
    public static final String URL_PATTERN = "https://www.biznesradar.pl/%s/%s,%s";
    public static final String INCOME_STATEMENT_URL = "raporty-finansowe-rachunek-zyskow-i-strat";
    public static final String BALANCE_SHEET_URL = "raporty-finansowe-bilans";
    public static final String CASH_FLOW_STATEMENT_URL = "raporty-finansowe-przeplywy-pieniezne";
    public static final String TABLE_CSS_QUERY = "table.report-table";
    public static final String TABLE_DATE_CSS_QUERY = "th[class^=thq h]";
    public static final String TABLE_ROW_CSS_QUERY = "tr[data-field=%s] td[class^=h] span.value span.pv span";

    private StatementCollectorValues() {
    }

}
