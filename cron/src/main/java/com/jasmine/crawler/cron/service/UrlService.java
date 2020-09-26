package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;

import java.util.List;

public interface UrlService {

    /**
     * Get url for down system site task
     *
     * @param downSystemSiteId
     * @param taskUrlBatchCount   count of url to crawl
     * @return
     */
    List<Url> getUrlToExecuteForSite(Integer downSystemSiteId, Integer taskUrlBatchCount);

    /**
     * Reset url status to wait which cached and has not been execute over max cache time,
     * it may have been lost
     *
     * @param downSystemSite
     * @return
     */
    int resetCachedUrlToWaitByDownSystemSite(DownSystemSite downSystemSite);

    /**
     * Reset failed to wait status and execute again if has not over url nax fail count
     *
     * @param downSystemSite
     * @return
     */
    int resetFailedUrlToWaitByDownSystemSite(DownSystemSite downSystemSite);

    /**
     * Reset succeed url to wait and execute again
     *
     * @param downSystemSite
     * @return
     */
    int resetSuccessUrlToWaitByDownSystemSite(DownSystemSite downSystemSite);
}
