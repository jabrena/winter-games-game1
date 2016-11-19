package com.wintergames.game1.service;

import com.wintergames.game1.stackoverflow.model.Answers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Game1RESTService implements Game1Service {

    private static final Logger logger = LoggerFactory.getLogger(Game1RESTService.class);

    private static final String STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS = "http://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=java&site=stackoverflow";

    @Autowired
    @Qualifier("stackOverflow")
    private RestTemplate restTemplate;

    @Override
    public Answers getQuestions() {

        final Answers result = restTemplate.getForObject(
                STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS, Answers.class);
        return result;

    }
}
