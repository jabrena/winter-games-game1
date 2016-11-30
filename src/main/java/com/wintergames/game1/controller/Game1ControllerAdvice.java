package com.wintergames.game1.controller;

import com.wintergames.game1.service.Game1ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Game1ControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(Game1Controller.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String globalError() {
        logger.error("Global Error");
        return "Error";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Game1ServiceException.class)
    public String serviceError() {
        logger.error("Game1ServiceException");
        return "Error";
    }

}
