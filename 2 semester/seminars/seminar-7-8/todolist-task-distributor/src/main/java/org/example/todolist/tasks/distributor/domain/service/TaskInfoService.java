package org.example.todolist.tasks.distributor.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.todolist.tasks.distributor.domain.model.TaskInfo;

import java.util.concurrent.TimeoutException;

@RequiredArgsConstructor
@Service
public class TaskInfoService {

    private final TaskInfoGateway taskInfoGateway;

    public TaskInfo getExtendedTaskInfo(String taskId) throws TimeoutException {
        return taskInfoGateway.getExtendedTaskInfo(taskId);
    }
}
