package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.Crawler;

public interface CrawlerService {
    /**
     * Reduce current concurrency
     *
     * @param crawlerId
     * @param concurrencyToDecrease
     */
    void reduceCurrentConcurrency(Integer crawlerId, Integer concurrencyToDecrease);

    /**
     * Get crawler info
     *
     * @param crawlerId
     * @return
     */
    Crawler get(Integer crawlerId);
}
