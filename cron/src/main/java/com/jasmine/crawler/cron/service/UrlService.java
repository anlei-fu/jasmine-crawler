package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;

import java.util.List;

public interface UrlService {

    /**
     * Get url for down system site
     *
     * @param downSystemSiteId
     * @param taskBatchCount  count of url to crawl
     * @return
     */
    List<Url> getUrlToExecuteForSite(Integer downSystemSiteId, Integer taskBatchCount);

    /**
     * Reset url status to wait which cached and has not been execute over max cache time
     *
     * @param downSystemSite
     * @return
     */
    int resetUrlStatusToWaitByDownSystemSite(DownSystemSite downSystemSite);
}
