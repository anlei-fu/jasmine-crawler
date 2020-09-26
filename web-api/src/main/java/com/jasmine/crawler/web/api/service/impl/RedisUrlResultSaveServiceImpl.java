package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.web.api.service.UrlResultSaveService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisUrlResultSaveServiceImpl extends LoggerSupport implements UrlResultSaveService {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void saveUrlResult(SaveUrlResultReq saveUrlResultReq) {
        try {
            RQueue<SaveUrlResultReq> queue = redissonClient.getQueue("url_queue");
            queue.add(saveUrlResultReq);
        } catch (Exception ex) {
            error("Save url failed", ex);
        }
    }

}
