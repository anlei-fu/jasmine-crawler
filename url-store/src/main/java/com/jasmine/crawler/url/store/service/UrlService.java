package com.jasmine.crawler.url.store.service;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;

import java.util.List;

public interface UrlService {

    /**
     * Get urls to run task
     *
     * @param downSystemSiteId
     * @return
     * @throws Exception
     */
    List<Url> getUrlForSite(Integer downSystemSiteId) throws Exception;

    /**
     * Save task url result
     *
     * @param req
     * @return
     */
    boolean saveTaskUrlResult(SaveUrlResultReq req);
}
