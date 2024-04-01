package org.example.todolist.domain.service;

import org.example.todolist.domain.model.TaskEntity;

public interface NotificationsGateway {

    void sendTaskInfo(TaskEntity taskEntity);
}
