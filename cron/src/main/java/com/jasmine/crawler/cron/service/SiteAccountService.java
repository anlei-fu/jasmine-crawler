package com.jasmine.crawler.cron.service;

public interface SiteAccountService {

    /**
     * Increase current use count
     *
     * @param accountId
     */
    void increaseCurrentUseCount(Integer accountId);

    /**
     * Decrease current use count
     *
     * @param accountId
     */
    void decreaseCurrentUseCount(Integer accountId);

    /**
     * Disable invalid and blocked account
     */
    void disableBlockedAccounts();

    void updateDelayTimeout(Integer accountId);
}
