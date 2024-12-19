package com.example.demo.exceptionhandling.exception;

public class DemoEventException extends DemoException{
    public DemoEventException(String errorCode) {
        super(errorCode);
    }
    public DemoEventException(){
        super();
    }
}
