package org.example.todolist.gateway.mapper;

import org.example.todolist.gateway.dto.TaskInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.todolist.domain.model.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskInfoMapper {

    @Mapping(source = "id", target = "taskId")
    TaskInfo mapToDto(TaskEntity taskEntity);
}