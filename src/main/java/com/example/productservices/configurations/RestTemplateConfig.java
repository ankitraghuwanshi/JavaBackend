package com.example.productservices.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    //note:- name of the class and method doesn't make any difference
    //create a bean of
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
