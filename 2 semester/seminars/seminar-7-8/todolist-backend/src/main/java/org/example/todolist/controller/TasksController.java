package org.example.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.todolist.controller.dto.TaskDto;
import org.example.todolist.domain.service.TasksService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TasksController {

    private final TasksService tasksService;

    @GetMapping
    public List<TaskDto> getTasks() {
        return tasksService.findAll();
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable("taskId") Long taskId) {
        return tasksService.findById(taskId);
    }

    @PostMapping
    public void createTask(@RequestBody TaskDto taskDto) {
        tasksService.create(taskDto);
    }
}
