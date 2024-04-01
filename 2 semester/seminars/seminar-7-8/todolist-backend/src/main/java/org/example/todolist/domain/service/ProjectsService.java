package org.example.todolist.domain.service;

import org.example.todolist.controller.dto.ProjectDto;

import java.util.List;

public interface ProjectsService {

    void create(ProjectDto projectDto);

    List<ProjectDto> getProjects();
}
