package org.example.todolist.domain.model.mapper;

import org.example.todolist.controller.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.todolist.domain.model.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity mapToEntity(TaskDto taskDto);
    @Mapping(source = "entity.project.id", target = "projectId")
    TaskDto mapToDto(TaskEntity entity);
}
