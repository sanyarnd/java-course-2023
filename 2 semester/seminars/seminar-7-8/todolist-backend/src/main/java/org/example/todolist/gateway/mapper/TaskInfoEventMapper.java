package org.example.todolist.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.todolist.avro.TaskInfoEvent;
import org.example.todolist.domain.model.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskInfoEventMapper {

    @Mapping(source = "id", target = "taskId")
    TaskInfoEvent mapToDto(TaskEntity taskEntity);
}