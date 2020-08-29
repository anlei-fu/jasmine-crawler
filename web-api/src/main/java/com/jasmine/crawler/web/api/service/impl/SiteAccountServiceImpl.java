package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.web.api.mapper.SiteAccountMapper;
import com.jasmine.crawler.web.api.service.SiteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteAccountServiceImpl implements SiteAccountService {

    @Autowired
    private SiteAccountMapper siteAccountMapper;

    @Override
    public SiteAccount get(Integer id) {
        return siteAccountMapper.get(id);
    }

    @Override
    public void increaseBlockCount(Integer id) {
        siteAccountMapper.increaseBlockCount(id);
    }

    @Override
    public void resetBlockCount(Integer id) {
        siteAccountMapper.resetBlockCount(id);
    }

    @Override
    public void decreaseCurrentUseCount(Integer id) {
        siteAccountMapper.decreaseCurrentUseCount(id);
    }

    @Override
    public void block(Integer id) {
        siteAccountMapper.block(id);
    }
}
