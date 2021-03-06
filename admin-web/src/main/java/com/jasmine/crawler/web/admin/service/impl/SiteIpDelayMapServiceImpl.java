/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.SiteIpDelayMapMapper;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteIpDelayMapPageReq;
import com.jasmine.crawler.web.admin.service.SiteIpDelayMapService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteIpDelayMapServiceImpl implements SiteIpDelayMapService {

    @Autowired
    private SiteIpDelayMapMapper siteIpDelayMapMapper;

    @Override
    public PageResult<SiteIpDelayMap> getPage(GetSiteIpDelayMapPageReq req) {
        return PageHelperUtils.paging(req, () -> siteIpDelayMapMapper.getPage(req));
    }

    @Override
    public boolean deleteById(Integer id) {
        return siteIpDelayMapMapper.deleteById(id) > 0;
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return siteIpDelayMapMapper.deleteBatch(ids);
    }
}
