package com.jasmine.crawler.common.support;

public interface Counter {
    boolean overMaxLimit(int value);

    void reduceMax(int value);

    boolean expired();
}
