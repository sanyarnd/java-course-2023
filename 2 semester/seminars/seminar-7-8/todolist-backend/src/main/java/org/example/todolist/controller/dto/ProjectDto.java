package org.example.todolist.controller.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Setter
@Getter
public class ProjectDto {

    @NotBlank
    private String name;
    @Min(1)
    private int priority;
}
