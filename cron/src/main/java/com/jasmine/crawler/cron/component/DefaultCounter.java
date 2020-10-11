package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;

public class DefaultCounter implements Counter {

    private final long expire;

    private final int max;

    private final Object LOCK = new Object();

    private int current;


    public DefaultCounter(int max, int expire) {
        this.max = max;
        this.expire = expire + System.currentTimeMillis();
    }

    @Override
    public boolean overMaxLimit(int value) {

        if (expired())
            return false;

        synchronized (LOCK) {
            current += value;
            return current > max;
        }
    }

    @Override
    public void reduceMax(int value) {
        synchronized (LOCK) {
            current -= value;
        }
    }

    @Override
    public boolean expired() {
        return expire < System.currentTimeMillis();
    }
}
