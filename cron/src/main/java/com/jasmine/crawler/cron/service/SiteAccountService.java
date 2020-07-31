package com.jasmine.crawler.cron.service;

public interface SiteAccountService {

    void disableAccounts();

    void increaseCurrentUseCount(Integer accountId);

    void decreaseCurrentUseCount(Integer accountId);
}
