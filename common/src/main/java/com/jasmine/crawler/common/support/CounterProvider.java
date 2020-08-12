package com.jasmine.crawler.common.support;

import java.util.Collection;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface CounterProvider extends Iterable<Counter> {
    Counter getCounter(String id,int max, int expire);

    void remove(String id);

    int size();
}
