package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.cron.pojo.entity.Url;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface UrlService {
    List<Url> getUrlToExecuteBySite(Integer siteId, Integer taskBatchCount);
}
