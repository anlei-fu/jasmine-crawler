package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.Application;
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
        service.getUrlForSite(1);
    }

    /**
     * Method: saveUrlResult(SaveUrlResultReq req)
     */
    @Test
    public void testSaveUrlResult() throws Exception {
        List<PageResult> prs =new LinkedList<>();
        PageResult pr =PageResult.builder()
                .msg("success")
                .httpStatus(200)
                .pageResult(1)
                .id(100)
                .taskId(1)
                .build();

        prs.add(pr);

        SaveUrlResultReq req = SaveUrlResultReq.builder()
                .taskId(1)
                .pageResults(prs)
                .build();
        service.saveTaskUrlResult(req);
    }

}
