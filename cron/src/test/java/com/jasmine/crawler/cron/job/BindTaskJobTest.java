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
 * BindTaskJob Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/30/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BindTaskJobTest {

    @Autowired
    private BindTaskJob service;

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
     * Method: bindTask(Integer level)
     */
    @Test
    public void testBindTask() throws Exception {

/* 
try { 
   Method method = BindTaskJob.getClass().getMethod("bindTask", Integer.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: bindTaskCore(CrawlTask taskToBind)
     */
    @Test
    public void testBindTaskCore() throws Exception {

/* 
try { 
   Method method = BindTaskJob.getClass().getMethod("bindTaskCore", CrawlTask.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsComponentInvalid(Object target, Integer taskToBindId, Integer bindStatus, CrawlTask taskToUpdate, String msg)
     */
    @Test
    public void testCheckIsComponentInvalid() throws Exception {

/* 
try { 
   Method method = BindTaskJob.getClass().getMethod("checkIsComponentInvalid", Object.class, Integer.class, Integer.class, CrawlTask.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: bindSuccess(Integer taskToBindId, CrawlTask crawlTaskToUpdate, Site site, DownSystemSite downSystemSite, Crawler crawler, Cookie cookie)
     */
    @Test
    public void testBindSuccess() throws Exception {

/* 
try { 
   Method method = BindTaskJob.getClass().getMethod("bindSuccess", Integer.class, CrawlTask.class, Site.class, DownSystemSite.class, Crawler.class, Cookie.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
