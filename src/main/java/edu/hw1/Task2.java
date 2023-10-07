package edu.hw1;

import java.util.logging.Logger;

public final class Task2 {
    private Task2() {
    }

    private static final Logger LOGGER = Logger.getLogger(Task2.class.getName());

    /**
     * Этот метод является точкой входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        LOGGER.info(String.valueOf(minutesToSeconds("01:00"))); // Вывод: 60
        LOGGER.info(String.valueOf(minutesToSeconds("13:56"))); // Вывод: 836
        LOGGER.info(String.valueOf(minutesToSeconds("10:60"))); // Вывод: -1
        LOGGER.info(String.valueOf(minutesToSeconds("999:59"))); // Вывод: 59939
    }

    public static int minutesToSeconds(String time) {
        String[] parts = time.split(":");
        @SuppressWarnings("checkstyle:magicnumber")
        int minutesInHour = 60;
        if (parts.length != 2 || time.charAt(time.length() - 1) == ':') {
            return -1; // некорректный формат строки
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            if (seconds >= minutesInHour) {
                return -1; // некорректное количество секунд
            }
            return minutes * minutesInHour + seconds;
        } catch (NumberFormatException e) {
            return -1; // некорректные символы в строке
        }
    }
}
