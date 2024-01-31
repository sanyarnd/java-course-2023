package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommandHandler {

    private final TaskTracker taskTracker = new SimpleTaskTracker(new InMemoryHistoryViewManager<>());

    public String addTask(String[] args) {
        var task = new Task()
            .setId(UUID.randomUUID())
            .setSummary(args[1])
            .setUser(args[2])
            .setPriority(Integer.parseInt(args[3]))
            .setStatus(TaskStatus.TODO)
            .setDateCreated(LocalDateTime.now());
        taskTracker.createTask(task);
        return task.toString();
    }

    public String getTask(String[] args) {
        UUID uuid = UUID.fromString(args[1]);
        return taskTracker.getTask(uuid).toString();
    }

    public String getHistory(String[] args) {
        return convertTasks(taskTracker.getViewHistory());
    }

    public String getAllTasks(String[] args) {
        return convertTasks(taskTracker.getAllTasks());
    }

    private String convertTasks(List<Task> tasks) {
        return tasks.stream()
            .map(Task::toString)
            .collect(Collectors.joining("\n"));
    }
}
