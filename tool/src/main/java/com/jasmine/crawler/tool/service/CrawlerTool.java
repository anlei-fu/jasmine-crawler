package com.jasmine.crawler.tool.service;

import com.jasmine.crawler.tool.mapper.CrawlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrawlerTool {

    @Autowired
    private CrawlerMapper crawlerMapper;

    public void resetConcurrency(Integer id) {
        crawlerMapper.resetConcurrency(id);
    }

    public void resetHeartbeatLost(Integer id) {
        crawlerMapper.resetHeartbeatLost(id);
    }
}
