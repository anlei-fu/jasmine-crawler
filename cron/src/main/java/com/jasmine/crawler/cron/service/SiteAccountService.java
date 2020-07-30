package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;

import java.util.List;

public interface SiteAccountService {
    List<SiteAccount> getBlockedAccount();

    void changeEnableStatusBatch(List<Integer> ids, Integer status);

    List<SiteAccount> getAccountsToEnable();

    void increaseCurrentUseCount(Integer accountId);

    void decreaseCurrentUseCount(Integer accountId);
}
