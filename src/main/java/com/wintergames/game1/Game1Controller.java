package com.wintergames.game1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/v1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public class Game1Controller {

    private static final Logger log = LoggerFactory.getLogger(Game1Controller.class);

    private static final String STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS = "http://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=java&site=stackoverflow";

    @GetMapping("/method1")
    public String method1() {

        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        final RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory));
        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new RESTInterceptor());
        restTemplate.setInterceptors(interceptors);

        final String result = restTemplate.getForObject(STACKOVERFLOW_JAVA_QUESTIONS_ADDRESS, String.class);
        log.info(result);
        return result;
    }


}
