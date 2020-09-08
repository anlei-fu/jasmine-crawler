package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.req.SaveTaskDataReq;
import com.jasmine.crawler.web.api.service.DataSaver;
import com.jasmine.crawler.web.api.service.DownSystemSiteService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueDataSaverImpl implements DataSaver {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Override
    public void saveData(SaveTaskDataReq saveDataResultReq) {

        try {
            Integer downSystemId = downSystemSiteService.get(saveDataResultReq.getDownSystemId()).getDownSystemId();
            RQueue<SaveTaskDataReq> queue = redissonClient.getQueue(String.format("data_queue_%d", downSystemId));
            queue.add(saveDataResultReq);
        } catch (Exception ex) {

        }
    }
}
