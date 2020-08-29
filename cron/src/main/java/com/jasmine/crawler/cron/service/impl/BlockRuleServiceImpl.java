package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.BlockRule;
import com.jasmine.crawler.cron.mapper.BlockRuleMapper;
import com.jasmine.crawler.cron.service.BlockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockRuleServiceImpl implements BlockRuleService {

    @Autowired
    private BlockRuleMapper blockRuleMapper;

    @Override
    public List<BlockRule> getByDownSystemSiteId(Integer downSystemSiteId) {
        return blockRuleMapper.getByDownSystemSiteId(downSystemSiteId);
    }
}
