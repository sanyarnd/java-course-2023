package edu.hw1;

public class task1 {
    public static int minutesToSeconds(String s) {
        final int secondsInMinute = 60;
        var a = s.split(":");
        int min = Integer.parseInt(a[0]);
        int sec = Integer.parseInt(a[1]);
        if (sec >= secondsInMinute) {
            return -1;
        }
        return min * secondsInMinute + sec;
    }
}
