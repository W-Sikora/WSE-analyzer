package pl.wsikora.wseanalyzer.util.document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class URLDocument {
    private static final int TIMEOUT = 5_000;

    private URLDocument() {
    }

    public static Document get(String url) {
        try {
            return Jsoup.parse(new URL(url), TIMEOUT);
        } catch (IOException e) {
            e.printStackTrace();
            return Jsoup.parse("");
        }
    }

    public static Document get(String urlPattern, Object... values) {
        return get(String.format(urlPattern, values));
    }

}
