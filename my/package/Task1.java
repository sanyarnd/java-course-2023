package edu.hw1;
import java.util.Scanner;

public class Task1{
    public static int VideoLength(String timeString) {
        String[] parts = timeString.split(":");
        if (parts.length != 2) {
            return -1; // Некорректный формат времени
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            if (seconds >= 60) {
                return -1; // Некорректное количество секунд
            }

            int totalSeconds = minutes * 60 + seconds;
            return totalSeconds;
        } catch (NumberFormatException e) {
            return -1; // Некорректный формат времени
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите время видео (в формате mm:ss): ");
        String timeString = scanner.nextLine();
        scanner.close();

        int totalSeconds = VideoLength(timeString);
        if (totalSeconds == -1) {
            System.out.println("Некорректное время.");
        } else {
            System.out.println("Общая длина видео в секундах: " + totalSeconds);
        }
    }
}
