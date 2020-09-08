package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.req.GetUrlForTaskReq;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.Application;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

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

    @Autowired
    private UrlMapper urlMapper;

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


    @Test
    public void testSuccess() {
        List<PageResult> pageResults = new LinkedList<>();
        PageResult p = new PageResult();

        p.setId(1);
        p.setHttpStatus(1);
        p.setPageResult(1);
        p.setTaskId(1);


        pageResults.add(p);
        urlMapper.successUrls(pageResults);
    }
}
