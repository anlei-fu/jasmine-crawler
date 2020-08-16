package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.Crawler;

public interface CrawlerService {
    /**
     * Decrease current concurrency
     *
     * @param crawlerId
     * @param concurrencyToDecrease
     */
    void decreaseCurrentConcurrency(Integer crawlerId, Integer concurrencyToDecrease);

    /**
     * Get crawler info
     *
     * @param crawlerId
     * @return
     */
    Crawler get(Integer crawlerId);
}
