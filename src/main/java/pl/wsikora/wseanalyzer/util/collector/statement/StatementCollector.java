package pl.wsikora.wseanalyzer.util.collector.statement;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.*;
import static pl.wsikora.wseanalyzer.util.date.DateParser.parseStatementDate;

public abstract class StatementCollector <T> {
    private final Elements table;
    private final int columnsNumber;

    protected StatementCollector(String url) {
        this.table = URLDocument.get(url).select(TABLE_CSS_QUERY);
        this.columnsNumber = table.select(TABLE_DATE_CSS_QUERY).size();
    }



    public T get(int index) {
        return form(index);
    }

    public T getLatest() {
        return form(columnsNumber - 1);
    }

    public List<T> getPart(int elementsNumber) {
        List<T> result = new ArrayList<>();
        int end = columnsNumber;
        for (int i = Math.max(end - elementsNumber, 0); i < end; i++) {
            result.add(form(i));
        }
        return result;
    }

    public abstract T form(int index);

    protected Optional<LocalDate> extractDate(int index) {
        return extractSingle(getTableDate(), index, e -> parseStatementDate(e.text().split("\\(")[1]));
    }

    protected Optional<Long> extractValue(Elements tableRow, int index) {
        return extractSingle(tableRow, index, e -> Long.parseLong(e.text().replaceAll("\\s", "")) * 1000);
    }

    protected void setSingleValue(String dataField, int index, Consumer<Long> consumer) {
        extractValue(getTableRow(dataField), index).ifPresent(consumer);
    }

    protected void setDate(int index, Consumer<LocalDate> consumer) {
        extractDate(index).ifPresent(consumer);
    }

    private Elements getTableRow(String dataField) {
        return table.select(String.format(TABLE_ROW_CSS_QUERY, dataField));
    }

    private Elements getTableDate() {
        return table.select(TABLE_DATE_CSS_QUERY);
    }

    private static <T> Optional<T> extractSingle(Elements elements, int index, Function<Element, T> function) {
        if (index > -1 && index < elements.size()) {
            try {
                return Optional.of(function.apply(elements.get(index)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

}
