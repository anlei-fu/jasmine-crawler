package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawl.common.pojo.entity.SiteUrlCheckRule;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class SiteBlockRuleServiceImpl implements SiteBlockRuleService {
    @Override
    public List<SiteUrlCheckRule> getRuleBySite(Integer siteId) {
        return null;
    }
}
