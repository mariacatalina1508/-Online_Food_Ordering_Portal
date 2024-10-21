package com.itschool.food.delivery.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(UserCreateException.class)
    public ResponseEntity<String> userCreateException(UserCreateException userCreateException) {
        return new ResponseEntity<>(objectToString(Map.of("message", userCreateException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(MenuCreateException.class)
    public ResponseEntity<String> menuCreateException(MenuCreateException menuCreateException) {
        return new ResponseEntity<>(objectToString(Map.of("message", menuCreateException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(OrderCreateException.class)
    public ResponseEntity<String> orderCreateException(OrderCreateException orderCreateException) {
        return new ResponseEntity<>(objectToString(Map.of("message", orderCreateException.getMessage())), NOT_FOUND);
    }

    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error("Error processing response to string");
            return "Internal error";
        }
    }
}