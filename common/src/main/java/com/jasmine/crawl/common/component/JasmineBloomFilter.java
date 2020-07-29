package com.jasmine.crawl.common.component;

import java.io.IOException;

public interface JasmineBloomFilter {
    boolean add(String url) throws Exception;

    void load(String data) throws IOException;

    String dump() throws IOException;

    void init(int expectedInsertions, double fpp);

    boolean initialized();

}
