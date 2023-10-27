package edu.hw1;

public class Task1 {
    public static int minutesToSeconds(String length) {
        String[] parts = length.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        if (seconds >= 60){
            return -1;
        }
        int totalSeconds = minutes * 60 + seconds;
        return totalSeconds;
    }
}
