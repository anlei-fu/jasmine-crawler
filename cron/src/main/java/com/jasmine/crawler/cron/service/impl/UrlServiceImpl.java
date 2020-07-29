package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawl.common.pojo.entity.Url;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Override
    public List<Url> getUrlToExecuteForSite(Integer siteId, Integer taskBatchCount) {
        return null;
    }
}
