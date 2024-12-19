package com.example.demo.exceptionhandling.exception;

public class DemoAPIException extends DemoException{
    public DemoAPIException(String errorCode) {
        super(errorCode);
    }
    public DemoAPIException(){
        super();
    }
}
