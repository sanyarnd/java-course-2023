package tinkoff2.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class JavaTime {
    public static void main(String[] args) {
        //create
        var now = Instant.now();
        System.out.println(now);

        //fixed clock
        System.out.println("Fixed clock");
        var fixedNow = Instant.now(Clock.fixed(Instant.MIN, ZoneId.systemDefault()));
        System.out.println(fixedNow);

        //truncatedTo
        System.out.println("\nTruncated");
        System.out.println(Instant.now().truncatedTo(ChronoUnit.MINUTES));

        //truncatedTo
        System.out.println("\nAdd days");
        System.out.println(Instant.now().plus(Duration.ofDays(3)));
        System.out.println(LocalDateTime.now().plusDays(3));

        //zoned
        System.out.println("\nZoned");
        System.out.println(Instant.now().atZone(ZoneId.of("Europe/Moscow")));
        System.out.println(Instant.now().atZone(ZoneId.of("Australia/Sydney")));

        //LocalDateTime
        System.out.println("\nLocalDateTime");
        var ldt = LocalDateTime.of(LocalDate.of(2023, 11, 7), LocalTime.now());
        System.out.println(ldt);

        //DateTimeFormatter
        System.out.println("\nDateTimeFormatter");
        LocalDate date = LocalDate.now();
        var formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(formatter);
        System.out.println(text);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate);

    }
}
