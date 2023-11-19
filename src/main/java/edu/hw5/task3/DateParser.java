package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateParser {
    public static Optional<LocalDate> parseDate(String string) {
        try {
            LocalDate date;
            if (string.equals("tomorrow")) {
                date = LocalDate.now().plusDays(1);
            } else if (string.equals("today")) {
                date = LocalDate.now();
            } else if (string.equals("yesterday")) {
                date = LocalDate.now().minusDays(1);
            } else if (string.endsWith(" days ago") || string.endsWith(" day ago")) {
                int daysAgo = Integer.parseInt(string.split(" ")[0]);
                date = LocalDate.now().minusDays(daysAgo);
            } else {
                date =
                    LocalDate.parse(string, DateTimeFormatter.ofPattern("[M/d/yyyy][yyyy-MM-dd][M/d/yy][yyyy-MM-d]"));
            }
            return Optional.of(date);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
