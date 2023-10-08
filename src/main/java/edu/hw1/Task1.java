package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private static final int SECONDS_IN_MINUTE = 60;

    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");

        if (parts.length != 2 || time.charAt(time.length() - 1) == ':') {
            return -1; // некорректный формат строки
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            if (seconds >= SECONDS_IN_MINUTE) {
                return -1; // некорректное количество секунд
            }
            return minutes * SECONDS_IN_MINUTE + seconds;
        } catch (NumberFormatException e) {
            return -1; // некорректные символы в строке
        }
    }
}
