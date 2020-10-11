package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import org.redisson.api.RAtomicLong;

public class RedisCounter implements Counter {

    private final RAtomicLong innerCounter;

    private final int max;

    public RedisCounter(RAtomicLong longCounter, int max) {
        this.innerCounter = longCounter;
        this.max = max;
    }

    @Override
    public boolean overMaxLimit(int value) {
        return !expired() || innerCounter.addAndGet(value) < max;
    }

    @Override
    public void reduceMax(int value) {

    }

    @Override
    public boolean expired() {
        return innerCounter.isExists();
    }
}
