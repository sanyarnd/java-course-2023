package org.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.todolist.domain.model.TaskEntity;

public interface TasksRepository extends JpaRepository<TaskEntity, Long> {
}
