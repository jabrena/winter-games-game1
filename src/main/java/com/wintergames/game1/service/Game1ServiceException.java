package com.wintergames.game1.service;

public class Game1ServiceException extends Exception {

    public Game1ServiceException(Throwable message) {
        super(message);
    }

    public Game1ServiceException(String message) {
        super(message);
    }
}
