package pl.wsikora.wseanalyzer.util.collector.statement;

import org.jsoup.select.Elements;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class StatementCollector<T> {
    private final Elements table;
    private final int size;
    private static final String URL_PATTERN = "https://www.biznesradar.pl/%s/%s,Q";
    private static final String TABLE_CSS_QUERY = "table[class=report-table]";
    private static final String DATA_FIELD_CSS_QUERY = "tr[data-field=%s] td[class^=h] span.value span.pv";

    protected StatementCollector(String statementPath, String businessRadarAcronym) {
        table = URLDocument.get(URL_PATTERN, statementPath, businessRadarAcronym)
                .select(TABLE_CSS_QUERY);
        size = table.select("th[class^=thq h]")
                .size();
    }

    public T get(int index) {
        return formStatement(index);
    }

    public T getLast() {
        return formStatement(size - 1);
    }

    public List<T> getPart(int elementsNumber) {
        int start = Math.max(size - elementsNumber, 0);
        return IntStream.range(start, size)
                .mapToObj(this::formStatement)
                .collect(Collectors.toList());
    }

    protected abstract T formStatement(int index);

    protected Long formValue(int index, String dataField) {
        return Long.parseLong(extractValue(index, dataField)) * 1_000L;
    }

    protected LocalDate formDate(int index) {
        int[] date = extractDateAsIntArray(index);
        return LocalDate.of(date[0], date[1] * 3, 1);
    }

    private String extractValue(int index, String dataField) {
        return table.select(String.format(DATA_FIELD_CSS_QUERY, dataField))
                .get(index)
                .text()
                .replaceAll("\\s+", "");
    }

    private String[] extractDateArray(int index) {
        return table.select("th[class^=thq h]")
                .get(index)
                .text()
                .replaceFirst("\\(.+\\)", "")
                .replaceFirst("Q", "")
                .replaceAll("\\s+", "")
                .split("/");
    }

    private int[] extractDateAsIntArray(int index) {
        return Arrays.stream(extractDateArray(index))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
