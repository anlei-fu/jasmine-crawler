package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.cron.mapper.SiteAccountMapper;
import com.jasmine.crawler.cron.service.SiteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteAccountServiceImpl implements SiteAccountService {

    @Autowired
    private SiteAccountMapper siteAccountMapper;

    @Override
    public List<SiteAccount> getBlockedAccount() {
        return siteAccountMapper.getBlockedAccount();
    }

    @Override
    public void changeEnableStatusBatch(List<Integer> ids, Integer status) {
        siteAccountMapper.changeEnableStatusBatch(ids,status);
    }

    @Override
    public List<SiteAccount> getAccountsToEnable() {
        return siteAccountMapper.getAccountsToEnable();
    }

    @Override
    public void increaseCurrentUseCount(Integer accountId) {
        siteAccountMapper.increaseCurrentUseCount(accountId);
    }

    @Override
    public void decreaseCurrentUseCount(Integer accountId) {
        siteAccountMapper.decreaseCurrentUseCount(accountId);
    }
}
