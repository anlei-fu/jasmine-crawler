package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.pojo.entity.SiteUrlCheckRule;
import com.jasmine.crawler.cron.service.SiteBlockRuleService;
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
