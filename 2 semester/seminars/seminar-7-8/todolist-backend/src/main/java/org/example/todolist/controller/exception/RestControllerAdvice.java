package org.example.todolist.controller.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestControllerAdvice
@Slf4j
public class RestControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorDto handle(MethodArgumentNotValidException ex) {
        log.error("Error: " + ex.getMessage());
        String name = ex.getParameter().getParameterName();
        return new ErrorDto("Неверные входные параметры. проверь " + name);
    }

    @Getter
    @RequiredArgsConstructor
    public class ErrorDto {
        private final String clientMessage;
    }
}
