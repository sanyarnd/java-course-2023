package org.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.todolist.domain.model.ProjectEntity;

public interface ProjectsRepository extends JpaRepository<ProjectEntity, Long> {
}
