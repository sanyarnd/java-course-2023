package org.example.todolist.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDto {

    private String text;
    private String status;
    private Long projectId;
}
