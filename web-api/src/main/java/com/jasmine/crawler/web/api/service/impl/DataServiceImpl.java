package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.req.SaveTaskDataReq;
import com.jasmine.crawler.web.api.service.CrawlTaskService;
import com.jasmine.crawler.web.api.service.DataService;
import com.jasmine.crawler.web.api.service.DownSystemSiteService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataServiceImpl implements DataService {

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
        }catch (Exception ex){

        }
    }
}
