package com.wintergames.game1;

import com.wintergames.game1.tools.LoggableDispatcherServlet;
import com.wintergames.game1.tools.RESTInterceptor;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
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

    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        return new ServletRegistrationBean(dispatcherServlet());
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LoggableDispatcherServlet();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public WebMvcConfigurerAdapter forwardToSwagger() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName(
                        "redirect:/swagger-ui.html");
            }
        };
    }

}
