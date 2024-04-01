package org.example.todolist.tasks.distributor.adapter.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.todolist.tasks.distributor.domain.service.TaskInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    private final TaskInfoService taskInfoService;

    @GetMapping
    public void test() throws TimeoutException {
        log.info("TEST TASK: " + taskInfoService.getExtendedTaskInfo("2"));
    }
}
