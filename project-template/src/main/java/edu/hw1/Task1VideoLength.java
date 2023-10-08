package edu.hw1;

import java.util.Objects;

final class Task1VideoLength {
    private Task1VideoLength() {
    }

    final public static int ONE_MINUTE = 60;

    public static int getSeconds(String time) {
        Objects.requireNonNull(time);
        String[] strTime = time.split(":");

        if (strTime.length != 2) {
            return -1;
        }
        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(strTime[0]);
            seconds = Integer.parseInt(strTime[1]);
            if (minutes < 0 || seconds >= ONE_MINUTE || seconds < 0) {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }

        return minutes * ONE_MINUTE + seconds;
    }
}
