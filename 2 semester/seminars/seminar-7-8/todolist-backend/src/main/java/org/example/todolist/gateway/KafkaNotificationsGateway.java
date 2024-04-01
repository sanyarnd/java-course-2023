package org.example.todolist.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.example.todolist.avro.TaskInfoEvent;
import org.example.todolist.domain.model.TaskEntity;
import org.example.todolist.domain.service.NotificationsGateway;
import org.example.todolist.gateway.mapper.TaskInfoEventMapper;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaNotificationsGateway implements NotificationsGateway {

    private final KafkaTemplate<String, TaskInfoEvent> taskInfoProducer;
    private final TaskInfoEventMapper taskInfoEventMapper;

    @Override
    public void sendTaskInfo(TaskEntity taskEntity) {
        try {
            taskInfoProducer.send("common.avro.notifications", String.valueOf(taskEntity.getId()),
                    taskInfoEventMapper.mapToDto(taskEntity));
        } catch (Exception ex) {
            log.error("Error occurred during sending to Kafka", ex);
        }
    }
}
