package com.wintergames.game1;

import com.wintergames.game1.base.Game1BaseControllerTest;
import com.wintergames.game1.model.Answers;
import com.wintergames.game1.model.stackoverflow.Item;
import com.wintergames.game1.service.Game1Service;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

public class Game1MocksControllerTest extends Game1BaseControllerTest {

    final static String METHOD1 = "/v1/resource1/sequence";

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private Game1Service game1Service;

    @Before
    public void setup() {
        final List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setIsAnswered(false);
        items.add(item);
        final Answers answers = new Answers(items);

        given(this.game1Service.getQuestionsInSequence())
                .willReturn(answers);
    }

    @Test
    public void getAnswersSucessMockTest() {
        Answers answer = this.restTemplate.getForObject(METHOD1, Answers.class);
        assertThat(answer.getItems().size(), is(1));
    }
}