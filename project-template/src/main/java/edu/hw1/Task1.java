package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        int result;
        if (sec >= 60) {
            System.out.println(-1);
            result = -1;
        } else {
            result = min * 60 + sec;
        }
        System.out.println(result);
        return result;
    }
}
