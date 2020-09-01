package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.url.store.mapper.CrawlTaskMapper;
import com.jasmine.crawler.url.store.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class CrawlTaskServiceImpl implements CrawlTaskService {

    @Autowired
    private CrawlTaskMapper crawlTaskMapper;

    @Override
    public void syncUrl(Integer taskId) {
        crawlTaskMapper.syncUrl(taskId);
    }
}
