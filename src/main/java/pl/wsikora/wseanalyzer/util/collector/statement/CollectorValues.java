package pl.wsikora.wseanalyzer.util.collector.statement;

public class CollectorValues {
    protected static final String URL_PATTERN = "https://www.biznesradar.pl/%s/%s,%s";
    protected static final String INCOME_STATEMENT_URL = "raporty-finansowe-rachunek-zyskow-i-strat";
    protected static final String BALANCE_SHEET_URL = "raporty-finansowe-bilans";
    protected static final String TABLE_CSS_QUERY = "table.report-table";
    protected static final String TABLE_DATE_CSS_QUERY = "th[class^=thq h]";
    protected static final String TABLE_ROW_CSS_QUERY = "tr[data-field=%s] td[class^=h] span.value span.pv span";

}
