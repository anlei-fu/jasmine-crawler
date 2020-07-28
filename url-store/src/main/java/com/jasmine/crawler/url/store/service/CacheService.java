package com.jasmine.crawler.url.store.service;

import java.util.Collection;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface CacheService<T> {
    Integer size();

    Integer cache(Collection<T> collection);

    Collection<T> get(Integer size);
}
