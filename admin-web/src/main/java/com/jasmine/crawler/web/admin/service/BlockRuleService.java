package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.BlockRule;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface BlockRuleService {
    boolean add(BlockRule blockRule);

    boolean delete(Integer id);

    int deleteBatch(List<Integer> ids);

    List<BlockRule> getByDownSystemSiteId(Integer downSystemSiteId);
}
