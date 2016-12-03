package com.wintergames.game1.controller;

import com.wintergames.game1.model.Answers;
import com.wintergames.game1.service.Game1Service;
import com.wintergames.game1.service.Game1ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/v1/resource1",
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
    public ResponseEntity<Answers> methodParallelFuture() throws Game1ServiceException {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Winter Games", "is coming");
        try {
            Answers answers = game1Service.getQuestionsFutures();
            return new ResponseEntity<Answers>(answers, responseHeaders, HttpStatus.OK);
        }catch(Game1ServiceException e){
            throw new Game1ServiceException("CASTAÑAZO TIMEOUT");
        }
    }

    @GetMapping("/parallel/futures/timeout")
    public Answers methodParallelFutureTimeout() throws Game1ServiceException {
        try {
            return game1Service.getQuestionsFuturesTimeout();
        }catch(Game1ServiceException e){
            throw new Game1ServiceException("CASTAÑAZO TIMEOUT");
        }
    }

    @GetMapping("/parallel/completablefutures")
    public ResponseEntity<Answers> methodParallelCompletableFuture() throws Game1ServiceException {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Winter Games", "is coming");
        try {
            Answers answers = game1Service.getQuestionsCompletableFutures();
            return new ResponseEntity<Answers>(answers, responseHeaders, HttpStatus.OK);
        }catch(Game1ServiceException e){
            throw new Game1ServiceException("CASTAÑAZO");
        }
    }

    @GetMapping("/parallel/completablefutures/timeout")
    public ResponseEntity<Answers> methodParallelCompletableFutureTimeout() throws Game1ServiceException {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Winter Games", "is coming");
        try {
            Answers answers = game1Service.getQuestionsCompletableFuturesTimeout();
            return new ResponseEntity<Answers>(answers, responseHeaders, HttpStatus.OK);
        }catch(Game1ServiceException e){
            throw new Game1ServiceException("CASTAÑAZO TIMEOUT");
        }
    }

    @GetMapping("/runtime/err")
    public Answers methodParallelFutureCrash() throws Game1ServiceException {
        throw new Game1ServiceException("CASTAÑAZO");
    }

}
