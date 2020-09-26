package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import org.springframework.stereotype.Component;

@Component
public class DefaultCounterProvider extends AbstractCounterProvider {

    @Override
    protected Counter createNewCounter(String id, int max, int expire) {
        return new DefaultCounter(max, expire);
    }
}
