package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.Url;

import java.util.List;

public interface UrlService {
    List<Url> getUrlToExecuteForSite(Integer siteId, Integer taskBatchCount);
}
