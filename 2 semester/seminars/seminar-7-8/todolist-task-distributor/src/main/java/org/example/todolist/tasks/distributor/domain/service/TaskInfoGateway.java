package org.example.todolist.tasks.distributor.domain.service;

import org.example.todolist.tasks.distributor.domain.model.TaskInfo;

import java.util.concurrent.TimeoutException;

public interface TaskInfoGateway {

    TaskInfo getExtendedTaskInfo(String taskId) throws TimeoutException;
}
