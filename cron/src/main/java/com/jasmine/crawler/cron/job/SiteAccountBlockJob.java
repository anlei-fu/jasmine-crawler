package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.cron.constant.BooleanFlag;
import com.jasmine.crawler.cron.pojo.entity.SiteAccount;
import com.jasmine.crawler.cron.service.SiteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class SiteAccountBlockJob {

    @Autowired
    private SiteAccountService siteAccountService;

    /**
     * To change site account enable status
     * 1. disabled
     * continuously failed over max thresh hold
     * 2. enable
     * site block timeout
     */
    @Scheduled(cron = "*/6 * * * * ?")
    public void disableBlockedAccount() {
        List<SiteAccount> accounts = null;
        try {
            accounts = siteAccountService.getBlockedAccount();
            if (accounts.size() == 0) {

            }
            List<Integer> ids = getSiteAccountIds(accounts);
            siteAccountService.changeEnableStatusBatch(ids, BooleanFlag.FALSE);
        } catch (Exception ex) {

        }

        accounts = null;
        try {
            accounts = siteAccountService.getAccountsToEnable();
            if (accounts.size() == 0) {

            }
            List<Integer> ids = getSiteAccountIds(accounts);
            siteAccountService.changeEnableStatusBatch(ids, BooleanFlag.TRUE);
        } catch (Exception ex) {

        }
    }

    private List<Integer> getSiteAccountIds(List<SiteAccount> accounts) {
        return null;
    }
}
