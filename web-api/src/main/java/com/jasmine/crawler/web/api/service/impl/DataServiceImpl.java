package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.req.SaveTaskDataReq;
import com.jasmine.crawler.web.api.service.CrawlTaskService;
import com.jasmine.crawler.web.api.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private RestTemplate template;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Override
    public void saveData(SaveTaskDataReq saveDataResultReq) {
         // ok
    }
}
