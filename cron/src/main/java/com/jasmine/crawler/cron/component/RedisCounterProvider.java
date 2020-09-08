package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import com.jasmine.crawler.common.support.CounterProvider;
import com.jasmine.crawler.common.support.LoggerSupport;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCounterProvider extends LoggerSupport implements CounterProvider {

    private static final Integer COUNTER_INACTIVE_TIMEOUT = 60 * 60 * 1000;

    private final ConcurrentHashMap<String, Counter> cache = new ConcurrentHashMap<>();

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public Counter getCounter(String id, int max, int expire) {
        Counter counter = cache.get(id);
        if (Objects.isNull(counter) || !counter.isExists())
            return createCounter(id, max, expire);

        return counter;
    }

    @Override
    public int clean() {
        int t = 0;
        for (final String key : cache.keySet()) {
            Counter counter = cache.get(key);
            if (!Objects.isNull(counter)) {
                if (counter.getLastActive() + COUNTER_INACTIVE_TIMEOUT < System.currentTimeMillis()) {
                    cache.remove(key);
                    t++;
                }
            }
        }

        return t;
    }

    private Counter createCounter(String id, int max, int expire) {
        RAtomicLong counter = redissonClient.getAtomicLong(id);
        counter.expire(expire, TimeUnit.SECONDS);
        RedisCounter c = new RedisCounter(counter, max);
        cache.computeIfPresent(id, (key, value) -> c);
        return c;
    }

}
