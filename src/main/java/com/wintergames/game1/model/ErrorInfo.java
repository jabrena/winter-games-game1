package com.wintergames.game1.model;

public class ErrorInfo {

    public final String exception;

    public ErrorInfo(Exception e) {
        this.exception = e.getLocalizedMessage();
    }
}
