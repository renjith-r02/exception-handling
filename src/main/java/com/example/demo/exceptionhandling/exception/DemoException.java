package com.example.demo.exceptionhandling.exception;

public class DemoException extends RuntimeException {
    private String errorCode;

    public DemoException(String errorCode) {
        super(errorCode);
    }
    public DemoException(){
        super();
    }
}
