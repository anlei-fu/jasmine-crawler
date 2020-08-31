package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.req.GetUrlForTaskReq;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UrlServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UrlServiceImplTest {

    @Autowired
    private UrlServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUrlForTask(GetUrlForTaskReq req)
     */
    @Test
    public void testGetUrlForTask() throws Exception {
        GetUrlForTaskReq req = GetUrlForTaskReq.builder()
                .downSystemSiteId(2)
                .build();
//        service.getUrlForTask(req);
    }

    /**
     * Method: saveUrlResult(SaveUrlResultReq req)
     */
    @Test
    public void testSaveUrlResult() throws Exception {
//        SaveUrlResultReq req = SaveUrlResultReq.builder()
//                .badUrls(null)
//                .failedUrls(null)
//                .downSystemSiteId(1)
//                .succeedUrls(null)
//                .unCrawledUrl(null)
//                .build();
//        service.saveTaskUrlResult(req);
    }

}
