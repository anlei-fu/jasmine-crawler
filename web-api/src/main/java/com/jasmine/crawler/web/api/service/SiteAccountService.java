package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;

public interface SiteAccountService {

    /**
     * Get account info
     *
     * @param accountId
     * @return
     */
    SiteAccount get(Integer accountId);

    /**
     * Increase current use count
     *
     * @param id
     */
    void increaseBlockCount(Integer id);

    /**
     * Set block count to 0
     *
     * @param id
     */
    void resetBlockCount(Integer id);

    /**
     * Decrease current current running task count
     *
     * @param id
     */
    void decreaseCurrentUseCount(Integer id);

    /**
     * Set status to disabled
     *
     * @param id
     */
    void block(Integer id);
}
