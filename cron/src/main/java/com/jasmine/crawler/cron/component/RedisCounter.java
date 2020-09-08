package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import org.redisson.api.RAtomicLong;

public class RedisCounter implements Counter {

    private final RAtomicLong innerCounter;

    private final int max;

    private long lastActive = System.currentTimeMillis();

    public RedisCounter(RAtomicLong longCounter, int max) {
        this.innerCounter = longCounter;
        this.max = max;
    }

    @Override
    public boolean addAndCheck(int value) {
        if (!isExists())
            return true;

        lastActive = System.currentTimeMillis();
        return innerCounter.addAndGet(value) < max;
    }

    @Override
    public boolean isExists() {
        return innerCounter.isExists();
    }

    @Override
    public long getLastActive() {
        return lastActive;
    }

}
