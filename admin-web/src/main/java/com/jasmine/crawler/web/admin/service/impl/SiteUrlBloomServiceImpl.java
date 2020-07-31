/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.SiteUrlBloomMapper;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteUrlBloomPageReq;
import com.jasmine.crawler.web.admin.service.SiteUrlBloomService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteUrlBloomServiceImpl implements SiteUrlBloomService {

    @Autowired private SiteUrlBloomMapper siteUrlBloomMapper;

    @Override
    public SiteUrlBloom getById(Integer id) {
        return siteUrlBloomMapper.getById(id);
    }

    @Override
    public PageResult<SiteUrlBloom> getPage(GetSiteUrlBloomPageReq req) {
        return PageHelperUtils.paging(req, () -> siteUrlBloomMapper.getPage(req));
    }
}
