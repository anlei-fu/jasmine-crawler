package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemRunLimitReq;

import java.util.List;

public interface DownSystemSiteRunLimitService {
    List<DownSystemSiteRunLimit> getByDownSystemSiteId(Integer downSystemSiteId);

    boolean disable(Integer id);

    boolean enable(Integer id);

    void createLimit(int id);

    boolean update(UpdateDownSystemRunLimitReq req);
}
