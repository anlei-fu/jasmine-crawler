package com.jasmine.crawler.common.support;

public interface CounterProvider {
    Counter getCounter(String id, int max, int expire);

    int clean();
}
