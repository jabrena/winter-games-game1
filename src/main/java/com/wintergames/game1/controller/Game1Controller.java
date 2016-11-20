package com.wintergames.game1.controller;

import com.wintergames.game1.service.Game1Service;
import com.wintergames.game1.stackoverflow.model.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value="/v1/resource",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class Game1Controller {

    @Autowired
    private Game1Service game1Service;

    public Game1Controller(Game1Service game1Service) {
        this.game1Service = game1Service;
    }

    @GetMapping("/method1")
    public Answers method1() {
        return game1Service.getQuestions();
    }


}
