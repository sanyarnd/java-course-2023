package org.example.todolist.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.controller.dto.ProjectDto;
import org.example.todolist.repository.ProjectsRepository;
import org.springframework.stereotype.Service;
import org.example.todolist.domain.model.mapper.ProjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectsService {

    private final ProjectsRepository projectsRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void create(ProjectDto projectDto) {
        projectsRepository.save(projectMapper.mapToEntity(projectDto));
    }

    @Override
    public List<ProjectDto> getProjects() {
        return projectsRepository.findAll()
                .stream()
                .map(projectMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
