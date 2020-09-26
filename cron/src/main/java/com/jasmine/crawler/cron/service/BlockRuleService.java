package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.BlockRule;

import java.util.List;

public interface BlockRuleService {

    /**
     * Get block rules of target site
     *
     * @param downSystemSiteId
     * @return
     */
    List<BlockRule> getByDownSystemSiteId(Integer downSystemSiteId);
}
