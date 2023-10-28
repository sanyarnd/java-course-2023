package org.example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TaskTracker {

    Task createTask(Task task);

    Task getTask(UUID uuid);

    List<Task> getViewHistory();

    List<Task> getAllTasks();

    /**
     * Метод возвращает список задач по приоритету
     * @return Список приоритетных задач
     */
    List<Task> getPriorityTasks();

    Map<TaskStatus, List<Task>> getTaskBoard();
}
