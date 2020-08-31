package com.jasmine.crawler.url.store.component;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class UrlResultQueue {

    @Bean
    public ConcurrentLinkedQueue<SaveUrlResultReq> create() {
        return new ConcurrentLinkedQueue<>();
    }
}
