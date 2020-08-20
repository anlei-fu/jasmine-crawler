package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;

import java.util.List;

public interface DownSystemSiteRunLimitService {
    List<DownSystemSiteRunLimit> getByDownSystemSiteId(Integer downSystemSiteId);

    boolean disable(Integer id);

    boolean enable(Integer id);
}
