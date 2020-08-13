package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import com.jasmine.crawler.web.api.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * SiteIpDelayMapServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SiteIpDelayMapServiceImplTest {

    @Autowired
    private SiteIpDelayMapServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(SiteIpDelayMap siteIpDelayMap)
     */
    @Test
    public void testAdd() throws Exception {
        SiteIpDelayMap siteIpDelayMap =SiteIpDelayMap.builder()
                .siteId(1).ip("12.5.3.65")
                .delayTimeoutTime(new Date())
                .build();
        service.add(siteIpDelayMap);
    }

} 
