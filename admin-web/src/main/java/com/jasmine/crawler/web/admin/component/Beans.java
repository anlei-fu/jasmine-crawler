package com.jasmine.crawler.web.admin.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Beans {

    @Bean
    public RestTemplate newResetTemplate(){
        return  new RestTemplate();
    }
}
