package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import com.jasmine.crawler.common.util.TestUtils;
import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RedisCounterProvider Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>09/26/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisCounterProviderTest {

    @Autowired
    private DefaultCounterProvider service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getCounter(String id, int max, int expire)
     */
    @Test
    public void testGetCounter() throws Exception {
        Counter counter = service.getCounter("test", 100000, 10000);
        for (int i = 0; i < 1000; i++) {
            TestUtils.print(counter.overMaxLimit(1000));
        }
    }

    /**
     * Method: clean()
     */
    @Test
    public void testClean() throws Exception {

    }


    /**
     * Method: createCounter(String id, int max, int expire)
     */
    @Test
    public void testCreateCounter() throws Exception {

    }

} 
