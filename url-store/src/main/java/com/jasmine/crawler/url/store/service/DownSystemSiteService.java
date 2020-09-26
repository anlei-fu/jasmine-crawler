package com.jasmine.crawler.url.store.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;

public interface DownSystemSiteService {

    /**
     * Get down system info
     *
     * @param downSystemId
     * @return
     */
    DownSystemSite get(Integer downSystemId);

    /**
     * Increase new url count
     *
     * @param downSystemSiteId
     * @param count
     */
    void addNewUrlCount(Integer downSystemSiteId, int count);

    /**
     * Increase bad url count
     *
     * @param id
     * @param count
     */
    void addBadUrlCount(Integer id, int count);

    /***
     * Increase finished url count
     *
     * @param id
     * @param count
     */
    void addFinishedUrlCount(Integer id, int count);
}
