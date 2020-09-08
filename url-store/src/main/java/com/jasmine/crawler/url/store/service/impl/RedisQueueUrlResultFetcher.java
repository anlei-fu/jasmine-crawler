package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.UrlResultFetcher;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisQueueUrlResultFetcher implements UrlResultFetcher {

    @Autowired
    private RQueue<SaveUrlResultReq> queue;

    public RedisQueueUrlResultFetcher(RedissonClient client) {
        queue = client.getQueue("url_queue");
    }

    @Override
    public SaveUrlResultReq fetch() {
        return queue.poll();
    }
}
