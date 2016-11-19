package com.wintergames.game1;

import com.wintergames.game1.stackoverflow.model.Answers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Game1App.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Game1ControllerTest {

    final static String METHOD1 = "/v1/resource/method1/";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test() throws Exception{
        Answers answer = this.restTemplate.getForObject("/v1/resource/method1/", Answers.class);
        assertThat(answer.getItems().size(), is(30));
    }
}