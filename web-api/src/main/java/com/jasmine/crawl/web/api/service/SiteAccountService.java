package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.SiteAccount;

public interface SiteAccountService {
    SiteAccount get(Integer accountId);

    void increaseBlockCount(Integer id);

    void resetBlockCount(Integer id);

    void decreaseCurrentUseCount(Integer id);
}
