package com.wintergames.game1.service;


import com.wintergames.game1.model.Answers;

public interface Game1Service {

    Answers getQuestionsInSequence();
    Answers getQuestionsFutures() throws Game1ServiceException;
    Answers getQuestionsFuturesTimeout() throws Game1ServiceException;

}
