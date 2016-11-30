package com.wintergames.game1.service;

import com.wintergames.game1.model.Answers;
import com.wintergames.game1.model.stackoverflow.Item;
import com.wintergames.game1.model.stackoverflow.StackOverflowAnswers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class Game1RESTService implements Game1Service {

    private static final Logger logger = LoggerFactory.getLogger(Game1RESTService.class);

    private static final String JAVA = "&tagged=java";
    private static final String JAVASCRIPT = "&tagged=javascript";
    private static final String STACKOVERFLOW_API_QUESTIONS_ADDRESS = "http://api.stackexchange.com/2.2/questions?order=desc&sort=activity&site=stackoverflow";
    private static final String STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS = STACKOVERFLOW_API_QUESTIONS_ADDRESS + JAVA;
    private static final String STACKOVERFLOW_JAVASCRIPT_QUESTIONS_ADDRESS = STACKOVERFLOW_API_QUESTIONS_ADDRESS + JAVASCRIPT;

    @Autowired
    @Qualifier("stackOverflow")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("stackOverflowTimeout")
    private RestTemplate badRestTemplate;

    private StackOverflowAnswers getJavaAnswers() {
        final StackOverflowAnswers javaAnswers = restTemplate.getForObject(
                STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS, StackOverflowAnswers.class);
        logger.info("Java answers downloaded");
        return javaAnswers;
    }

    private StackOverflowAnswers getJavaScriptAnswers() {
        final StackOverflowAnswers javascriptAnswers =  restTemplate.getForObject(
                STACKOVERFLOW_JAVASCRIPT_QUESTIONS_ADDRESS, StackOverflowAnswers.class);
        logger.info("Javascript answers downloaded");
        return javascriptAnswers;
    }

    private StackOverflowAnswers getJavaScriptAnswersTimeout() {
        final StackOverflowAnswers javascriptAnswers =  badRestTemplate.getForObject(
                STACKOVERFLOW_JAVASCRIPT_QUESTIONS_ADDRESS, StackOverflowAnswers.class);
        logger.info("Javascript answers downloaded");
        return javascriptAnswers;
    }

    @Override
    public Answers getQuestionsInSequence() {

        final List<Item> answerList = new ArrayList<>();
        answerList.addAll(this.getJavaAnswers().getItems());
        answerList.addAll(this.getJavaScriptAnswers().getItems());
        return new Answers(answerList);
    }

    @Override
    public Answers getQuestionsFutures() throws Game1ServiceException {
        final ExecutorService executor = Executors.newFixedThreadPool(2);

        final Future<List<Item>> future1 = executor.submit(() -> {
            return this.getJavaAnswers().getItems();
        });

        final Future<List<Item>> future2 = executor.submit(() -> {
            return this.getJavaScriptAnswers().getItems();
        });

        final List<Item> answerList = new ArrayList<>();
        try {
            answerList.addAll(future1.get());
            answerList.addAll(future2.get());
            executor.shutdownNow();
            return new Answers(answerList);
        } catch (InterruptedException e) {
            throw new Game1ServiceException(e);
        } catch (ExecutionException e) {
            throw new Game1ServiceException(e);
        }

    }

    @Override
    public Answers getQuestionsFuturesTimeout() throws Game1ServiceException {
        final ExecutorService executor = Executors.newFixedThreadPool(2);

        final Future<List<Item>> future1 = executor.submit(() -> {
            return this.getJavaAnswers().getItems();
        });

        final Future<List<Item>> future2 = executor.submit(() -> {
            return this.getJavaScriptAnswersTimeout().getItems();
        });

        final List<Item> answerList = new ArrayList<>();
        try {
            answerList.addAll(future1.get());
            answerList.addAll(future2.get());
            executor.shutdownNow();
            return new Answers(answerList);
        } catch (InterruptedException e) {
            throw new Game1ServiceException(e);
        } catch (ExecutionException e) {
            throw new Game1ServiceException(e);
        }
    }
}
