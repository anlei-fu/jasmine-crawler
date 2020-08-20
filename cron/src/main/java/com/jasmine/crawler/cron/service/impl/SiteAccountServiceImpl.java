package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.SiteAccountMapper;
import com.jasmine.crawler.cron.service.SiteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteAccountServiceImpl implements SiteAccountService {

    @Autowired
    private SiteAccountMapper siteAccountMapper;

    @Override
    public void disableBlockedAccounts() {
        siteAccountMapper.disableAccounts();
    }

    @Override
    public void updateDelayTimeoutTime(Integer accountId) {
        siteAccountMapper.updateDelayTimeout(accountId);
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
