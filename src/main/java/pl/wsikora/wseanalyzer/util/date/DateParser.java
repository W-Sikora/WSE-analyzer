package pl.wsikora.wseanalyzer.util.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private DateParser() {
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
