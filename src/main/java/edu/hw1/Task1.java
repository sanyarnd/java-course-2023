package edu.hw1;

public class Task1 {
    private static final int SECONDS = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String s) {
        var a = s.split(":");
        int min = Integer.parseInt(a[0]);
        int sec = Integer.parseInt(a[1]);
        if (sec >= SECONDS) {
            return -1;
        }
        return min * SECONDS + sec;
    }
}