package com.jasmine.crawler.web.api.service;

import java.util.List;

public interface UrlService {

    /**
     * Reset url status to wait and total crawl count to 0
     *
     * @param ids
     * @return
     */
    Integer resetUrls(List<Integer> ids);

    /**
     * Reset sedd url status to wait and total crawl count to 0
     *
     * @param downSystemSiteId
     * @return
     */
    Integer resetSeedUrl(Integer downSystemSiteId);
}
