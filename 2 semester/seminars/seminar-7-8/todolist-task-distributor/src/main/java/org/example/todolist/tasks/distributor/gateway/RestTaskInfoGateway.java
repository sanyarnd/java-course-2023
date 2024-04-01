package org.example.todolist.tasks.distributor.gateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.example.todolist.tasks.distributor.domain.model.TaskInfo;
import org.example.todolist.tasks.distributor.domain.service.TaskInfoGateway;

import java.util.Random;
import java.util.concurrent.TimeoutException;

@RequiredArgsConstructor
@Component
public class RestTaskInfoGateway implements TaskInfoGateway {

    private final RestTemplate restTemplate;

    @Retry(name = "taskInfoService", fallbackMethod = "getRandomTask")
    @CircuitBreaker(name = "taskInfoService", fallbackMethod = "getRandomTask")
    @Override
    public TaskInfo getExtendedTaskInfo(String taskId) throws TimeoutException {
        int sleep = new Random().nextInt(3) + 1;
        if (sleep == 3) {
            longRunning();
        }
        ResponseEntity<TaskInfo> response = restTemplate.exchange(
                "http://todolist-backend/tasks/{taskId}",
                HttpMethod.GET, null, TaskInfo.class, taskId);

        return response.getBody();
    }

    private void longRunning() throws TimeoutException {
        try {
            Thread.sleep(5_000);
            throw new TimeoutException();
        } catch (InterruptedException e) {

        }
    }

    public TaskInfo getRandomTask(String taskId, Throwable throwable) {
        TaskInfo taskInfo = new TaskInfo();
        Random random = new Random();
        taskInfo.setTaskId(random.nextLong());
        taskInfo.setStatus("NEW");
        taskInfo.setProjectId(random.nextLong());
        return taskInfo;
    }
}
