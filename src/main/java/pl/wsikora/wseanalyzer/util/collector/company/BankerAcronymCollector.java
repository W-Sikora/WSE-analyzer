package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankerAcronymCollector {
    private static final String ACRONYM_URL = "https://www.bankier.pl/gielda/notowania/ranking-popularnosci?start=%s";
    private static final List<String> VALUES = List.of("0-9", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z");
    private static final String ACRONYM_CSS_QUERY = "td.colWalor";
    private static final String TICKER_CSS_QUERY = "td.colTicker";

    private BankerAcronymCollector() {
        throw new AssertionError();
    }

    public static Map<String, String> collect() {
        Map<String, String> result = new HashMap<>();
        for (String value : VALUES) {
            for (Element e : extractElements(value)) {
                result.put(e.select(TICKER_CSS_QUERY).text(),
                        e.select(ACRONYM_CSS_QUERY).text());
            }
        }
        return result;
    }

    private static Elements extractElements(String value) {
        return URLDocument.get(ACRONYM_URL, value)
                .select("tbody tr");
    }

}
