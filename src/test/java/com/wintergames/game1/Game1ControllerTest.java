package com.wintergames.game1;

import com.wintergames.game1.model.Answers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Game1App.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Game1ControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(Game1ControllerTest.class);

    final static String METHOD1 = "/v1/resource/method1/";

    @Autowired
    private TestRestTemplate restTemplate;

//    public Game1ControllerTest(){
//        ClientHttpRequestInterceptor ri = new LoggingRequestInterceptor();
//        List<ClientHttpRequestInterceptor> ris = new ArrayList<ClientHttpRequestInterceptor>();
//        ris.add(ri);
//        restTemplate.setInterceptors(ris);
//        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
//    }

    @Test
    public void getAnswerSequenceSuccessTest() throws Exception{
        Answers answer = this.restTemplate.getForObject("/v1/resource/sequence/", Answers.class);
        assertThat(answer.getItems().size(), is(60));
    }

    @Test
    public void getAnswerParallelFuturesSuccessTest() throws Exception{
        Answers answer = this.restTemplate.getForObject("/v1/resource/parallel/futures", Answers.class);
        assertThat(answer.getItems().size(), is(60));
    }

    @Test
    public void getAnswerParallelFuturesTimeoutTest() throws Exception{
        String response = this.restTemplate.getForObject("/v1/resource/parallel/futures/timeout", String.class);
        logger.info(response);
        assertThat(response, is(nullValue()));
    }

    @Test
    public void getAnswerRuntimeErrorTest() throws Exception{
        String response = this.restTemplate.postForObject("/v1/resource/runtime/err",null, String.class);
        logger.info(response);
        assertThat(response, is(nullValue()));
    }

    @Test
    public void getAnswerUnknownResourceTest() throws Exception{
        String response = this.restTemplate.getForObject("/v1/resource/unknown", String.class);
        logger.info(response);
        assertThat(response, is(nullValue()));
    }
}