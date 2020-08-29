package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.BlockRule;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface BlockRuleService {
    List<BlockRule> getByDownSystemSiteId(Integer id);
}
