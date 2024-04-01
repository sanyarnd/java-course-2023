package org.example.todolist.tasks.distributor.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class TaskInfo {

    private Long taskId;
    private String status;
    private Long projectId;
}
