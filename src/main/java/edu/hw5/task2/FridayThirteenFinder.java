package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayThirteenFinder {
    public static List<LocalDate> findFridaysThirteens(int year) {
        List<LocalDate> fridaysThirteens = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysThirteens.add(date);
            }
        }
        return fridaysThirteens;
    }

    public static LocalDate findNextFridayThirteen(LocalDate date) {
        LocalDate resDate = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (resDate.getDayOfMonth() != 13) {
            resDate = resDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return resDate;
    }
}
