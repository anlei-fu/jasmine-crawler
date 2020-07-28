package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.SiteUrlCheckRule;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface SiteBlockRuleService {
    List<SiteUrlCheckRule> getRuleBySite(Integer siteId);
}
