package pl.wsikora.wseanalyzer.util.collector.company;

import org.jsoup.nodes.Element;
import pl.wsikora.wseanalyzer.util.document.URLDocument;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.WSE_BUSINESS_RADAR_ACRONYM_URL;
import static pl.wsikora.wseanalyzer.util.collector.CollectorValues.NC_BUSINESS_RADAR_ACRONYM_URL;

public class BusinessRadarAcronymCollector {
    private static final String CSS_QUERY = "table[class=qTableFull] tr[id^=qtable-s-] a[class^=s_tt s_tt_sname_]";
    private static final String targetToReplaced = "/notowania/";

    public static List<String> collectAll() {
        return Stream.of(collect(WSE_BUSINESS_RADAR_ACRONYM_URL), collect(NC_BUSINESS_RADAR_ACRONYM_URL))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<String> collect(String url) {
        return URLDocument.get(url)
                .select(CSS_QUERY)
                .stream()
                .map(BusinessRadarAcronymCollector::getAcronym)
                .collect(Collectors.toList());
    }

    private static String getAcronym(Element element) {
        return element.attr("href")
                .replace(targetToReplaced, "");
    }

}
