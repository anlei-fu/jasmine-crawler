package com.jasmine.crawler.web.api.component;

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
public class Beans {

    @Bean
    public RestTemplate createRestClient(){
        return  new RestTemplate();
    }
}
