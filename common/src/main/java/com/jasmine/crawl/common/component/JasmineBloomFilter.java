package com.jasmine.crawl.common.component;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface JasmineBloomFilter {
    boolean add(String url);
    boolean load(String data);
    String  dump();
}
