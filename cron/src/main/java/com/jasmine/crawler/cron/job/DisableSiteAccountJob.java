package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.SiteAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisableSiteAccountJob extends LoggerSupport {

    @Autowired
    private SiteAccountService siteAccountService;

    /**
     * To check the account that over max block count and set block timeout time
     */
//    @Scheduled(cron = "*/6 * * * * ?")
    public void disableBlockedAccount() {

        info("-------------begin to disable blocked site account---------------------- ");
        List<SiteAccount> accounts = null;
        try {
            siteAccountService.disableBlockedAccounts();
        } catch (Exception ex) {
            error("disable account failed", ex);
        }
    }
}
