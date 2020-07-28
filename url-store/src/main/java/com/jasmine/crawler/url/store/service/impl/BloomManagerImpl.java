package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawl.common.component.JasmineBloomFilter;
import com.jasmine.crawler.url.store.mapper.BloomMapper;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class BloomManagerImpl implements BloomFilterManager {

    private ConcurrentHashMap<Integer, JasmineBloomFilter> cache =new ConcurrentHashMap<>();

    @Autowired
    private BloomMapper bloomMapper;

    @Override
    public JasmineBloomFilter getBloomById(Integer id) {
        return null;
    }
}
