package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.BlockRule;
import com.jasmine.crawler.web.admin.mapper.BlockRuleMapper;
import com.jasmine.crawler.web.admin.service.BlockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockRuleServiceImpl implements BlockRuleService {

    @Autowired
    private BlockRuleMapper blockRuleMapper;

    @Override
    public boolean add(BlockRule blockRule) {
        return blockRuleMapper.add(blockRule) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return blockRuleMapper.delete(id) > 0;
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return blockRuleMapper.deleteBatch(ids);
    }

    @Override
    public List<BlockRule> getByDownSystemSiteId(Integer downSystemSiteId) {
        return blockRuleMapper.getByDownSystemSiteId(downSystemSiteId);
    }
}
