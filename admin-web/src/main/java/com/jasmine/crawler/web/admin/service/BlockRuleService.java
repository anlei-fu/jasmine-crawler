package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.BlockRule;

import java.util.List;

public interface BlockRuleService {
    boolean add(BlockRule blockRule);

    boolean delete(Integer id);

    int deleteBatch(List<Integer> ids);

    List<BlockRule> getByDownSystemSiteId(Integer downSystemSiteId);
}
