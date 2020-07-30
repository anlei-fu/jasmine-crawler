package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.pojo.entity.Crawler;

public interface CrawlerService {
    void decreaseCurrentConcurrency(Integer crawlerId, Integer concurrencyToDecrease);

    Crawler get(Integer crawlerId);

    void update(CrawlTask crawlTaskToUpdate);
}
