package com.jasmine.crawler.url.store.service;

import com.jasmine.crawl.common.component.JasmineBloomFilter;
import com.jasmine.crawler.url.store.pojo.entity.JasmineBloomWrapper;

import java.io.IOException;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface BloomFilterManager {
    JasmineBloomFilter get(Integer id) throws IOException;

    Iterable<JasmineBloomWrapper> getAll();

    void remove(Integer id);

}
