package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisCounterProvider extends AbstractCounterProvider {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    protected Counter createNewCounter(String id, int max, int expire) {
        RAtomicLong counter = redissonClient.getAtomicLong(id);
        RedisCounter redisCounter = new RedisCounter(counter, max);
        return redisCounter;
    }

}
