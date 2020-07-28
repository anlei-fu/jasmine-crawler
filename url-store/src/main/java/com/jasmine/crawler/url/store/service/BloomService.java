package com.jasmine.crawler.url.store.service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface BloomService {
    boolean createNewBloom(Integer id);

    boolean disableById(Integer id);

    boolean filterUrl(String url) throws Exception;
}
