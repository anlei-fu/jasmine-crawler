package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.Crawler;

public interface CrawlerService {
    void decreaseCurrentConcurrencyById(Integer crawlerId);

    Crawler get(Integer crawlerId);
}
