package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.component.impl.JasmineBloomFilterImpl;
import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.url.store.Application;
import com.jasmine.crawler.url.store.component.JasmineBloomWrapper;
import com.jasmine.crawler.url.store.mapper.BloomMapper;
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

    @Autowired
    private BloomMapper bloomMapper;

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
        JasmineBloomFilter wrapper = service.get(46);


        System.out.println(wrapper.add("#1/娘妻"));
        System.out.println(wrapper.add("#1/巨野/324450"));
        SiteUrlBloom siteUrlBloom = SiteUrlBloom.builder()
                .id(46)
                .bloom(wrapper.dump())
                .build();

        //    bloomMapper.dump(siteUrlBloom);
        JasmineBloomFilterImpl filter = new JasmineBloomFilterImpl();
        filter.load(wrapper.dump());

        System.out.println(filter.add("#1/巨野/324450"));
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
