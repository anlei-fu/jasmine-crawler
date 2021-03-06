package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.web.api.mapper.CrawlerMapper;
import com.jasmine.crawler.web.api.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Autowired
    private CrawlerMapper crawlerMapper;

    @Override
    public void reduceCurrentConcurrency(Integer crawlerId, Integer concurrencyToDecrease) {
        crawlerMapper.reduceCurrentConcurrency(crawlerId, concurrencyToDecrease);
    }

    @Override
    public Crawler get(Integer crawlerId) {
        return crawlerMapper.get(crawlerId);
    }

}
