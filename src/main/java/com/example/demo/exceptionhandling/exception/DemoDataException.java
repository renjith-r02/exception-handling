package com.example.demo.exceptionhandling.exception;

public class DemoDataException extends DemoException{
    public DemoDataException(String errorCode) {
        super(errorCode);
    }
    public DemoDataException(){
        super();
    }
}
