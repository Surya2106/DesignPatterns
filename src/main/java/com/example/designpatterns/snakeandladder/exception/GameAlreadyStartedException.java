package com.example.designpatterns.snakeandladder.exception;

public class GameAlreadyStartedException extends Exception {

    public GameAlreadyStartedException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
