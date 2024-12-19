package com.example.demo.exceptionhandling.handler;

import com.example.demo.exceptionhandling.exception.DemoAPIException;
import com.example.demo.exceptionhandling.exception.DemoDataException;
import com.example.demo.exceptionhandling.exception.DemoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DemoException.class)
    public ResponseEntity<String> handleDemoException(DemoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DemoDataException.class)
    public ResponseEntity<String> handleDemoDataException(DemoDataException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DemoAPIException.class)
    public ResponseEntity<String> handleDemoAPIException(DemoAPIException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}