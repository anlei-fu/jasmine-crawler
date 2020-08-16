package com.jasmine.crawler.common.support;

public interface CounterProvider extends Iterable<Counter> {
    Counter getCounter(String id, int max, int expire);

    void remove(String id);

    int size();
}
