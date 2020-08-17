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
 * HeartbeatJob Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>08/13/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HeartbeatJobTest {

    @Autowired
    private HeartbeatJob service;

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
     * Method: sendHeartbeatCore(Crawler crawler, Heartbeat heartbeat)
     */
    @Test
    public void testSendHeartbeatCore() throws Exception {

/* 
try { 
   Method method = HeartbeatJob.getClass().getMethod("sendHeartbeatCore", Crawler.class, Heartbeat.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
