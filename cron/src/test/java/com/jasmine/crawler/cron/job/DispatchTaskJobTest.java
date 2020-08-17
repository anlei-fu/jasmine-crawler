package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DispatchTaskJob Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>08/13/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DispatchTaskJobTest {

    @Autowired
    private DispatchTaskJob service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: run()
     */
    @Test
    public void testRun() throws Exception {
        service.run();
    }

    /**
     * Method: dispatchTaskCore(CrawlTaskConfig crawlTaskConfig)
     */
    @Test
    public void testDispatchTaskCore() throws Exception {

    }

    /**
     * Method: dispatchFailed(CrawlTaskConfig crawlTaskConfig, Integer dispatchResult, String dispatchMsg)
     */
    @Test
    public void testDispatchFailed() throws Exception {

    }

    /**
     * Method: dispatchSuccess(CrawlTaskConfig crawlTaskConfig, Crawler crawler, Proxy proxy, Site site, Cookie cookie)
     */
    @Test
    public void testDispatchSuccess() throws Exception {

    }

    /**
     * Method: getTaskConfigsToRun()
     */
    @Test
    public void testGetTaskConfigsToRun() throws Exception {

/* 
try { 
   Method method = DispatchTaskJob.getClass().getMethod("getTaskConfigsToRun"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: validate(Object target, CrawlTaskConfig crawlTaskConfig, Integer dispatchStatus, String msg)
     */
    @Test
    public void testValidate() throws Exception {

/* 
try { 
   Method method = DispatchTaskJob.getClass().getMethod("validate", Object.class, CrawlTaskConfig.class, Integer.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
