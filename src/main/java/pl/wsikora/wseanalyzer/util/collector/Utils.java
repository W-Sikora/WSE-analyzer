package pl.wsikora.wseanalyzer.util.collector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    private static final int timeout = 5_000;
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static Document getDocument(String url) {
        try {
            return Jsoup.parse(new URL(url), timeout);
        } catch (IOException e) {
            e.printStackTrace();
            return Jsoup.parse("");
        }
    }

    public static LocalDate formDate(String date) {
        int year = Integer.parseInt(date.replaceAll("\\D+", "")) + 2000;
        if (date.contains("mar")) {
            return LocalDate.of(year, 3, 1);
        } else if (date.contains("cze")) {
            return LocalDate.of(year, 6, 1);
        } else if (date.contains("wrz")) {
            return LocalDate.of(year, 9, 1);
        } else if (date.contains("gru")) {
            return LocalDate.of(year, 12, 1);
        }
        return LocalDate.now();
    }

}
