package com.wintergames.game1;

import com.wintergames.game1.tools.RESTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Game1Config {

    @Bean("stackOverflow")
    public RestTemplate getRESTTemplate(){
        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(1000);
        clientHttpRequestFactory.setConnectTimeout(1000);
        final RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory));
        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new RESTInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    //TODO Move to tests
    @Bean("stackOverflowTimeout")
    public RestTemplate getRESTTemplateTimeout(){
        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(1);
        clientHttpRequestFactory.setConnectTimeout(1);
        final RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory));
        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(new RESTInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

}
