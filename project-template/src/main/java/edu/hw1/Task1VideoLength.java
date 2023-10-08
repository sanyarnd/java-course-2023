package edu.hw1;

import java.util.Objects;

final class Task1VideoLength {
    final int minute = 60;

    public static int getSeconds(String time) {
        Objects.requireNonNull(time);
        String[] strTime = time.split(":");

        if (strTime.length != 2) {
            return -1;
        }
        int min;
        int sec;

        try {
            min = Integer.parseInt(strTime[0]);
            sec = Integer.parseInt(strTime[1]);
            if (min < 0 || sec >= minute || sec < 0) {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }

        return min * minute + sec;
    }
}
