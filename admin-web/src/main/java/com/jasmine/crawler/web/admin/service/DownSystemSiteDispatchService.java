package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.web.admin.pojo.vo.DownSystemSiteDispatchDetail;

import java.util.List;

public interface DownSystemSiteDispatchService {
    List<DownSystemSiteDispatchDetail> getBySourceDownSystemSiteId(Integer downSystemSiteId);

    boolean add(DownSystemSiteDispatch req);

    boolean delete(Integer id);
}
