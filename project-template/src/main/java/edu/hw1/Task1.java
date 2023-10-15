package edu.hw1;

public class Task1 {
    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        String[] mas = time.split(":");
        if (mas.length != 2) {
            throw new IllegalArgumentException("Invalide format");
        }
        try {

            int min = Integer.parseInt(mas[0]);
            int sec = Integer.parseInt(mas[1]);
            if (min < 0 || sec < 0) {
                throw new IllegalArgumentException("Invalid values");
            }
            int totalSeconds = min * 60 + sec;

            return totalSeconds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valiable only numbers");
        }
    }
}
