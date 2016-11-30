package com.wintergames.game1.controller;

import com.wintergames.game1.model.Answers;
import com.wintergames.game1.service.Game1Service;
import com.wintergames.game1.service.Game1ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value="/v1/resource",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class Game1Controller {

    @Autowired
    private Game1Service game1Service;

    public Game1Controller(Game1Service game1Service) {
        this.game1Service = game1Service;
    }

    @GetMapping("/sequence/")
    public Answers method1() {
        return game1Service.getQuestionsInSequence();
    }

    @GetMapping("/parallel/futures")
    public Answers methodParallelFuture() throws Game1ServiceException {
        return game1Service.getQuestionsFutures();
    }

    @GetMapping("/parallel/futures/timeout")
    public Answers methodParallelFutureTimeout() throws Game1ServiceException {
        return game1Service.getQuestionsFuturesTimeout();
    }

    @PostMapping("/runtime/err")
    public Answers methodParallelFutureCrash() throws Game1ServiceException {
        throw new Game1ServiceException("CASTAÑAZO");
    }

}
