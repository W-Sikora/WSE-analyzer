package pl.wsikora.wseanalyzer.util.collector;

public class CollectorValues {
    static final int timeout = 5_000;
    static final String URL_PATTERN = "https://www.biznesradar.pl/%s/%s";
    static final String TABLE_CSS_QUERY = "table.report-table";
    static final String TABLE_DATE_CSS_QUERY = "th[class^=thq h]";
    static final String TABLE_ROW_CSS_QUERY = "tr[data-field=%s] td[class^=h] span.value span.pv span";



}
