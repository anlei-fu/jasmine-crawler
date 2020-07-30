package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.SiteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SiteAccountBlockJob extends LoggerSupport {

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

        info("-------------begin to disable blocked site account---------------------- ");
        List<SiteAccount> accounts = null;
        try {
            accounts = siteAccountService.getBlockedAccount();
            if (accounts.size() == 0) {
                info("no account need to disabled");
            } else {
                siteAccountService.changeEnableStatusBatch(getSiteAccountIds(accounts), BooleanFlag.FALSE);
                info(String.format("get %d account to disable", accounts.size()));
            }
        } catch (Exception ex) {
            error("disable account failed", ex);
        }

        info("-------------begin to enable blocked site account---------------------- ");
        try {
            accounts = siteAccountService.getAccountsToEnable();
            if (accounts.size() == 0) {
                info("no account need to be enabled");
                return;
            }
            siteAccountService.changeEnableStatusBatch(getSiteAccountIds(accounts), BooleanFlag.TRUE);
            info(String.format("get %d account to enable", accounts.size()));
        } catch (Exception ex) {
            error("enable account failed", ex);
        }
    }

    private List<Integer> getSiteAccountIds(List<SiteAccount> accounts) {
        return null;
    }
}
