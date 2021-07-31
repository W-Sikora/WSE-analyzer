package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Element;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessRadarAcronymCollector {
    private static final String ACRONYM_CSS_QUERY = "table[class=qTableFull] tr[id^=qtable-s-] a[class^=s_tt s_tt_sname_]";
    private static final String WSE_ACRONYM_URL = "https://www.biznesradar.pl/gielda/akcje_gpw";
    private static final String NC_ACRONYM_URL = "https://www.biznesradar.pl/gielda/newconnect";

    private BusinessRadarAcronymCollector() {
        throw new AssertionError();
    }

    public static List<String> collectWSEAcronyms() {
        return collect(WSE_ACRONYM_URL);
    }

    public static List<String> collectNCAcronyms() {
        return collect(NC_ACRONYM_URL);
    }

    private static List<String> collect(String url) {
        return URLDocument.get(url)
                .select(ACRONYM_CSS_QUERY)
                .stream()
                .map(BusinessRadarAcronymCollector::form)
                .collect(Collectors.toList());
    }

    private static String form(Element element) {
        return element.attr("href")
                .replace("/notowania/", "");
    }

}
