package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawl.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.cron.service.SiteAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class SiteAccountServiceImpl implements SiteAccountService {
    @Override
    public List<SiteAccount> getBlockedAccount() {
        return null;
    }

    @Override
    public void changeEnableStatusBatch(List<Integer> ids, Integer status) {

    }

    @Override
    public List<SiteAccount> getAccountsToEnable() {
        return null;
    }
}
