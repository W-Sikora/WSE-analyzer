package pl.wsikora.wseanalyzer.util.collector;

public class CollectorValues {
    public static final String COMPANY_PAGE_URL = "https://www.biznesradar.pl/notowania/%s";
    public static final String URL_PATTERN = "https://www.biznesradar.pl/%s/%s,%s";
    public static final String INCOME_STATEMENT_URL = "raporty-finansowe-rachunek-zyskow-i-strat";
    public static final String BALANCE_SHEET_URL = "raporty-finansowe-bilans";
    public static final String CASH_FLOW_STATEMENT_URL = "raporty-finansowe-przeplywy-pieniezne";
    public static final String TABLE_CSS_QUERY = "table.report-table";
    public static final String TABLE_DATE_CSS_QUERY = "th[class^=thq h]";
    public static final String TABLE_ROW_CSS_QUERY = "tr[data-field=%s] td[class^=h] span.value span.pv span";
    public static final String PROFILE_SUMMARY_CSS_QUERY = "#left-content div[class=box-left] table.profileSummary";
    public static final String BANKER_ACRONYMS_URL = "https://www.bankier.pl/gielda/notowania/ranking-popularnosci?start=%s";
    public static final String WSE_BUSINESS_RADAR_ACRONYM_URL = "https://www.biznesradar.pl/gielda/akcje_gpw";
    public static final String NC_BUSINESS_RADAR_ACRONYM_URL = "https://www.biznesradar.pl/gielda/newconnect";

    private CollectorValues() {
    }

}
