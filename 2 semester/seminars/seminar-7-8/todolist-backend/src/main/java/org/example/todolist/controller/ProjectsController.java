package org.example.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.example.todolist.controller.dto.ProjectDto;
import org.example.todolist.domain.service.ProjectsService;

import jakarta.validation.Valid;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/projects")
@RestController
public class ProjectsController {

    private final ProjectsService projectsService;

    @GetMapping
    public List<ProjectDto> getProjects() {
        return projectsService.getProjects();
    }

    @PostMapping
    public void createProject(@RequestBody @Valid ProjectDto projectDto) {
        projectsService.create(projectDto);
    }
}
