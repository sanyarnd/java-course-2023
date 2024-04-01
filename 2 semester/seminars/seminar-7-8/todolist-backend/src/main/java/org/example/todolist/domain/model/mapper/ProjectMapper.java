package org.example.todolist.domain.model.mapper;

import org.example.todolist.controller.dto.ProjectDto;
import org.mapstruct.Mapper;
import org.example.todolist.domain.model.ProjectEntity;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectEntity mapToEntity(ProjectDto projectDto);

    ProjectDto mapToDto(ProjectEntity entity);
}
