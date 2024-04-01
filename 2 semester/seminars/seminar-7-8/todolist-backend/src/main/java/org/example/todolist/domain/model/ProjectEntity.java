package org.example.todolist.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@Table(name = "projects")
@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant created;

    private String name;

    private Integer priority;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, targetEntity = TaskEntity.class)
    private List<TaskEntity> tasks;
}