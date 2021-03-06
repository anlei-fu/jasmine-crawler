/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.SiteIpBlockMapMapper;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteIpBlockMapPageReq;
import com.jasmine.crawler.web.admin.service.SiteIpBlockMapService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteIpBlockMapServiceImpl implements SiteIpBlockMapService {

    @Autowired
    private SiteIpBlockMapMapper siteIpBlockMapMapper;

    @Override
    public PageResult<SiteIpBlockMap> getPage(GetSiteIpBlockMapPageReq req) {
        return PageHelperUtils.paging(req, () -> siteIpBlockMapMapper.getPage(req));
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return siteIpBlockMapMapper.deleteBatch(ids);
    }
}
