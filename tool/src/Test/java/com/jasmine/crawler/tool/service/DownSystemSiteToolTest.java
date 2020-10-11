package com.jasmine.crawler.tool.service;

import com.jasmine.crawler.tool.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemSiteToolTest {

    @Autowired
    private DownSystemSiteTool downSystemSiteTool;

    @Test
    public void testResetConcurrency() {
        downSystemSiteTool.resetConcurrency(51);
    }

    @Test
    public void testResetSeedUrlStatus() {
        downSystemSiteTool.resetSeedUrlStatus(49);
    }

    @Test
    public void testUrlStatus() {
        downSystemSiteTool.resetUrlStatus(49);
    }

    @Test
    public void testResetCachedUrlStatus() {
        downSystemSiteTool.resetCachedUrlStatus(49);
    }

    @Test
    public void testBalanceRunLimit() {
        downSystemSiteTool.balanceRunLimit(51);
    }

    @Test
    public void testCreateLimit() {
        downSystemSiteTool.createLimit(51, 7, 24);
    }
}
