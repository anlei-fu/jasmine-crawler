package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.url.store.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BloomManagerImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BloomManagerImplTest {

    @Autowired
    private BloomManagerImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get(Integer id)
     */
    @Test
    public void testGet() throws Exception {
       service.get(1);
    }

    /**
     * Method: getAll()
     */
    @Test
    public void testGetAll() throws Exception {
           service.getAll();
    }

    /**
     * Method: remove(Integer id)
     */
    @Test
    public void testRemove() throws Exception {
        service.remove(1);
    }


} 
