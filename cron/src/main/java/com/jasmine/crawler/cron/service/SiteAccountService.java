package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.SiteAccount;

import java.util.List;

public interface SiteAccountService {
    List<SiteAccount> getBlockedAccount();

    void changeEnableStatusBatch(List<Integer> ids, Integer status);

    List<SiteAccount> getAccountsToEnable();
}
