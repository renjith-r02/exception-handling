package com.example.demo.exceptionhandling.util;

import org.springframework.stereotype.Component;

@Component
public class TimeUtil {

    public static long getCurrentEpochTime() {
        return System.currentTimeMillis();
    }
}