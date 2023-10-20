package edu.hw1;

public class Task1 {

    private Task1() {

    }

    public static int minutesToSeconds(String time) {
        final int secInMinute = 60;
        String[] parts = time.split(":");
        if ((!time.contains(":")) || (parts[0].isEmpty()) || (parts[1].isEmpty())) {
            return -1;
        }
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        if (sec >= secInMinute) {
            return -1;
        } else {
            return (min * secInMinute + sec);
        }
    }
}
