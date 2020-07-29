package com.jasmine.crawler.url.store.component;

import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class UrlResultQueue {

    @Bean
    public ConcurrentLinkedQueue<SaveUrlResultReq> create() {
        return new ConcurrentLinkedQueue<>();
    }
}
