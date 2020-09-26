package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;

import java.util.List;
import java.util.Map;

public interface DownSystemSiteDispatchService {

    /**
     * Dispatch url to target down System Site
     *
     * @param req
     * @param downSystemSiteId
     * @return
     */
    Map<Integer, List<Url>> dispatch(SaveTaskResultReq req,Integer downSystemSiteId);
}
