package com.wintergames.game1.controller;

import com.wintergames.game1.model.ErrorInfo;
import com.wintergames.game1.service.Game1ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class Game1ControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(Game1ControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorInfo globalError(Exception e) {
        logger.error("Global Error");
        return new ErrorInfo(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Game1ServiceException.class)
    public ErrorInfo serviceError(Game1ServiceException e) {
        logger.error("Game1ServiceException");
        return new ErrorInfo(e);
    }

}
