package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.BANKER_ACRONYMS_URL;
import static pl.wsikora.wseanalyzer.util.document.URLDocument.get;

public class BankerAcronymCollector {
    private static final List<String> values = List.of("0-9", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z");
    private static final String TICKER_CSS_QUERY = "td.colTicker";
    private static final String ACRONYM_CSS_QUERY = "td.colWalor";

    private BankerAcronymCollector() {
    }

    public static Map<String, String> getTickersWithBankerAcronym() {
        List<String> tickers = new ArrayList<>();
        List<String> acronyms = new ArrayList<>();
        values.forEach(e -> {
                    Document document = get(formUrl(e));
                    tickers.addAll(extractTexts(document, TICKER_CSS_QUERY));
                    acronyms.addAll(extractTexts(document, ACRONYM_CSS_QUERY));
            sleep(20L);
        });
        return zipToMap(tickers, acronyms);
    }

    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private static List<String> extractTexts(Document document, String cssQuery) {
        return document.select(cssQuery)
                .eachText();
    }

    private static String formUrl(String start) {
        return String.format(BANKER_ACRONYMS_URL, start);
    }

}
