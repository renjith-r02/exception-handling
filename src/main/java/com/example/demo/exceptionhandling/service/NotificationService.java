package com.example.demo.exceptionhandling.service;


import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    @EventListener
    public void handle(com.example.demo.exceptionhandling.util.UserRegisteredEvent event) {

        System.out.println("User registered event received:");
        System.out.println("Email: " + event.getEmail());
        System.out.println("First Name: " + event.getFirstName());
        System.out.println("Last Name: " + event.getLastName());
    }
}
