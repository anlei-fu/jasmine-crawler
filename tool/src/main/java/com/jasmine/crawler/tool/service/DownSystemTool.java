package com.jasmine.crawler.tool.service;


import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.tool.mapper.CrawlTaskMapper;
import com.jasmine.crawler.tool.mapper.DownSystemMapper;
import com.jasmine.crawler.tool.mapper.DownSystemSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DownSystemTool extends LoggerSupport {

    @Autowired
    private CrawlTaskMapper crawlTaskMapper;

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Transactional
    public void resetConcurrency(Integer downSystemId) {
        int total = crawlTaskMapper.deleteTaskByDownSystem(downSystemId);
        info(String.format("delete %d task", total));
        downSystemMapper.resetConcurrency(downSystemId);

        List<Integer> downSystemSiteIds = downSystemMapper.getAllDownSystemSiteId(downSystemId);
        downSystemSiteIds.stream().forEach(x -> {
            downSystemSiteMapper.resetConcurrency(x);
        });
    }
}
