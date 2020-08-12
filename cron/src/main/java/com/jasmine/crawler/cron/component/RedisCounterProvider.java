package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import com.jasmine.crawler.common.support.CounterProvider;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class RedisCounterProvider implements CounterProvider {

    private ConcurrentHashMap<String, Counter> cache = new ConcurrentHashMap<>();

    // @Autowired
    private RedissonClient redissonClient;

    @Override
    public Counter getCounter(String id, int max, int expire) {
        Counter c = cache.get(id);
        if (Objects.isNull(c)) {
            c = new RedisCounter(redissonClient, id, max, expire);
            cache.putIfAbsent(id, c);
        }

        return cache.get(id);
    }

    @Override
    public void remove(String id) {
        cache.remove(id);
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public Iterator<Counter> iterator() {
        return (Iterator<Counter>) cache.values();
    }
}
