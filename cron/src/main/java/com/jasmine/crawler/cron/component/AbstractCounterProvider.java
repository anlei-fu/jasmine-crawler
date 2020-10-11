package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import com.jasmine.crawler.common.support.CounterProvider;
import com.jasmine.crawler.common.support.LoggerSupport;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractCounterProvider extends LoggerSupport implements CounterProvider {
    protected final ConcurrentHashMap<String, Counter> cache = new ConcurrentHashMap<>();

    public Counter getCounter(String id, int max, int expire) {
        Counter counter = cache.get(id);

        if (!Objects.isNull(counter) && !counter.expired())
            return counter;

        Counter c = createNewCounter(id, max, expire);
        cache.putIfAbsent(id, c);
        return c;
    }

    @Override
    public int clean() {
        int t = 0;
        for (Map.Entry<String, Counter> entry : cache.entrySet()) {

            if (entry.getValue().expired()) {
                cache.remove(entry.getKey());
                t++;
            }
        }

        return t;
    }

    protected abstract Counter createNewCounter(String id, int max, int expire);
}
