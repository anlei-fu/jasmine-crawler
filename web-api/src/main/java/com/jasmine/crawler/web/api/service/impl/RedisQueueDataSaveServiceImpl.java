package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.req.SaveTaskDataReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.web.api.service.DataSaveService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueDataSaveServiceImpl extends LoggerSupport implements DataSaveService {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void saveData(SaveTaskDataReq saveDataResultReq) {

        try {
            RQueue<SaveTaskDataReq> queue = redissonClient.getQueue(String.format("data_queue_%d", saveDataResultReq.getDownSystemId()));
            queue.add(saveDataResultReq);
        } catch (Exception ex) {
            error("save data failed", ex);
        }
    }
}
