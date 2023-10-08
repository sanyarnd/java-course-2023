package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    private static final int MINUTES_IN_HOUR = 60;

    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");

        if (parts.length != 2 || time.charAt(time.length() - 1) == ':') {
            return -1; // некорректный формат строки
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            if (seconds >= MINUTES_IN_HOUR) {
                return -1; // некорректное количество секунд
            }
            return minutes * MINUTES_IN_HOUR + seconds;
        } catch (NumberFormatException e) {
            return -1; // некорректные символы в строке
        }
    }
}
