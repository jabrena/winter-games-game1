package com.wintergames.game1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.RouterFunction;
import org.springframework.web.reactive.function.ServerResponse;

import static org.springframework.http.codec.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.RequestPredicates.GET;
import static org.springframework.web.reactive.function.RouterFunctions.route;

@Component
public class Game1Routes {

    private static final Logger log = LoggerFactory.getLogger(Game1Routes.class);

    private static final String STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS = "http://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=java&site=stackoverflow";

    //TODO Move to a handler
    private static String getValuesFromStackOverFlow(){

        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        final RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory));
        final String result = restTemplate.getForObject(STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS, String.class);
        log.info(result);

        return result;
    }

    public static RouterFunction<String> method1() {

        return route(GET("/resource/v1/method1"),
                request -> ServerResponse
                        .ok()
                        .body(fromObject(getValuesFromStackOverFlow())));
    }

}
