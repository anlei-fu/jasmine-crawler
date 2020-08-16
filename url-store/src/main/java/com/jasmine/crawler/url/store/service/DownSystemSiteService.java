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
     * @param size
     */
    void increaseNewUrlCount(Integer downSystemSiteId, int size);

    /**
     * Increase bad url count
     *
     * @param id
     * @param size
     */
    void increaseBadUrlCount(Integer id, int size);

    void increaseFinishedUrlCount(Integer id, int size);
}
