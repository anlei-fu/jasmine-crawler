package com.jasmine.crawler.tool.service;

import com.jasmine.crawler.tool.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrawleToolTest {

    @Autowired
    private CrawlerTool crawlerTool;

    @Test
    public void testResetConcurrency() {
        crawlerTool.resetConcurrency(10);
    }

    @Test
    public void testResetHeartbeatLost() {
        crawlerTool.resetHeartbeatLost(10);
    }
}
