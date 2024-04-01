package org.example.todolist.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.controller.dto.TaskDto;
import org.example.todolist.repository.ProjectsRepository;
import org.example.todolist.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.example.todolist.domain.exception.ProjectNotFoundException;
import org.example.todolist.domain.exception.TaskNotFoundException;
import org.example.todolist.domain.model.ProjectEntity;
import org.example.todolist.domain.model.TaskEntity;
import org.example.todolist.domain.model.mapper.TaskMapper;
import org.example.todolist.gateway.KafkaNotificationsGateway;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final TaskMapper taskMapper;
    private final TasksRepository tasksRepository;
    private final ProjectsRepository projectsRepository;
    private final KafkaNotificationsGateway kafkaNotificationsGateway;

    @Override
    public List<TaskDto> findAll() {
        return tasksRepository.findAll()
                .stream()
                .map(taskMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto findById(Long taskId) {
        return taskMapper.mapToDto(tasksRepository.findById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @Override
    public void create(TaskDto taskDto) {
        ProjectEntity project = projectsRepository.findById(taskDto.getProjectId()).orElseThrow(
                ProjectNotFoundException::new
        );

        TaskEntity taskEntity = taskMapper.mapToEntity(taskDto);
        taskEntity.setProject(project);
        TaskEntity saved = tasksRepository.save(taskEntity);

        kafkaNotificationsGateway.sendTaskInfo(saved);
    }
}
