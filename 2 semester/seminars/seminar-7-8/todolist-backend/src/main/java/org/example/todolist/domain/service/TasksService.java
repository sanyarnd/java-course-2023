package org.example.todolist.domain.service;

import org.example.todolist.controller.dto.TaskDto;

import java.util.List;

public interface TasksService {

    List<TaskDto> findAll();

    TaskDto findById(Long taskId);

    void create(TaskDto taskDto);
}
