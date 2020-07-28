package com.jasmine.crawler.url.store.service;

import com.jasmine.crawl.common.component.JasmineBloomFilter;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface BloomFilterManager {
    JasmineBloomFilter getBloomById(Integer id);
}
