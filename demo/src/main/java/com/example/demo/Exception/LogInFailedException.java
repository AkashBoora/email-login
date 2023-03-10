package com.example.demo.Exception;

public class LogInFailedException extends RuntimeException{
    public LogInFailedException(String message) {
        super(message);
    }
}
