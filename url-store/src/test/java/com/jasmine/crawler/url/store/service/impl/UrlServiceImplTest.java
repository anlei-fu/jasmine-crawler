package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.url.store.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * UrlServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>09/26/2020</pre>
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
     * Method: getUrlForSite(Integer downSystemSiteId)
     */
    @Test
    public void testGetUrlForSite() throws Exception {

    }

    /**
     * Method: saveNewUrl(List<Url> newUrls, Integer downSystemSiteId)
     */
    @Test
    public void testSaveNewUrl() throws Exception {

        List <Url> urls =new ArrayList<>();
        Url url = Url.builder()
                .url("test")
                .build();
        urls.add(url);

        service.addNewUrl(urls,49);
    }

    /**
     * Method: saveUrlResult(SaveUrlResultReq req)
     */
    @Test
    public void testSaveUrlResult() throws Exception {

    }


    /**
     * Method: saveNormalUrlResult(SaveUrlResultReq req, DownSystemSite downSystemSite)
     */
    @Test
    public void testSaveNormalUrlResult() throws Exception {

    }

    /**
     * Method: updateUrlStatusToCached(List<Url> urls)
     */
    @Test
    public void testUpdateUrlStatusToCached() throws Exception {

    }

    /**
     * Method: saveNewUrlCore(List<Url> newUrls, Integer downSystemSiteId)
     */
    @Test
    public void testSaveNewUrlCore() throws Exception {

    }

    /**
     * Method: failedUrls(List<PageResult> urls)
     */
    @Test
    public void testFailedUrls() throws Exception {

    }

    /**
     * Method: badUrls(List<PageResult> urls, DownSystemSite downSystemSite)
     */
    @Test
    public void testBadUrls() throws Exception {

    }

    /**
     * Method: failToRunUrls(List<PageResult> urls)
     */
    @Test
    public void testFailToRunUrls() throws Exception {

    }

    /**
     * Method: succeedUrls(List<PageResult> urls, DownSystemSite downSystemSite)
     */
    @Test
    public void testSucceedUrls() throws Exception {

    }

} 
