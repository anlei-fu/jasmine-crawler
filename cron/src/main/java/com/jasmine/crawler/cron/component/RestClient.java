package com.jasmine.crawler.cron.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class RestClient {
    @Bean
    public RestTemplate create(){
        return  new RestTemplate();
    }
}
