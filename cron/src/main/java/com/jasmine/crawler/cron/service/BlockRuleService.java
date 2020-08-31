package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.BlockRule;

import java.util.List;

public interface BlockRuleService {
    List<BlockRule> getByDownSystemSiteId(Integer id);
}
