package com.jasmine.crawler.cron.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    @Bean
    public RestTemplate create() {
        return new RestTemplate();
    }
}
