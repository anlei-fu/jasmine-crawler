package com.jasmine.crawl.common.component.impl;

import com.google.common.hash.BloomFilter;
import com.jasmine.crawl.common.component.JasmineBloomFilter;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class JasmineImpl implements JasmineBloomFilter {
    @Override
    public boolean add(String url) {
        return false;
    }

    @Override
    public boolean load(String data) {
        return false;
    }

    @Override
    public String dump() {
        return null;
    }
}
