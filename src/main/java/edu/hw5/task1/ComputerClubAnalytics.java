package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ComputerClubAnalytics {
    public static Duration calculateAverageSessionDuration(List<String> sessions) {
        long totalSeconds = 0;
        for (String session : sessions) {
            String[] parts = session.split(" - ");
            LocalDateTime start = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
            LocalDateTime end = LocalDateTime.parse(parts[1], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
            totalSeconds += Duration.between(start, end).getSeconds();
        }
        long averageSeconds = totalSeconds / sessions.size();
        return Duration.ofSeconds(averageSeconds);
    }
}
