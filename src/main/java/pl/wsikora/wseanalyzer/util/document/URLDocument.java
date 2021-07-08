package pl.wsikora.wseanalyzer.util.document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class URLDocument {
    private static final int timeout = 5_000;

    private URLDocument() {
    }

    public static Document getDocument(String url) {
        try {
            return Jsoup.parse(new URL(url), timeout);
        } catch (IOException e) {
            e.printStackTrace();
            return Jsoup.parse("");
        }
    }

}
