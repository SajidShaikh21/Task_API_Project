package com.example.exception;

public class TaskNoFoundException extends RuntimeException{

    public TaskNoFoundException(String message) {

        super(message);
    }
}
