package com.jasmine.crawler.url.store.component;

import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class RedisClient {

    @Bean
    public   RedissonClient createRedissonClient(){
         return  null;
    }
}
