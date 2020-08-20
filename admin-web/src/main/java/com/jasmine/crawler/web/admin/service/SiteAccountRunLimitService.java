package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.SiteAccountRunLimit;

import java.util.List;

public interface SiteAccountRunLimitService {
    List<SiteAccountRunLimit> getByDownSystemSiteId(Integer downSystemSiteId);

    boolean disable(Integer id);

    boolean enable(Integer id);
}
