/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.UrlMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateParams;
import com.jasmine.crawler.web.admin.pojo.req.AddUrlReq;
import com.jasmine.crawler.web.admin.pojo.req.GetUrlPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;
import com.jasmine.crawler.web.admin.service.UrlService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public boolean add(AddUrlReq req) {
        return urlMapper.add(req) > 0;
    }

    @Override
    public boolean deleteByUrl(String url) {
        return urlMapper.deleteByUrl(url) > 0;
    }

    @Override
    public boolean updateByUrl(String url, UpdateUrlReq req) {
        UpdateParams params = new UpdateParams(url, req);
        return urlMapper.updateByUrl(params) > 0;
    }

    @Override
    public Url getByUrl(String url) {
        return urlMapper.getByUrl(url);
    }

    @Override
    public PageResult<Url> getPage(GetUrlPageReq req) {
        return PageHelperUtils.paging(req, () -> urlMapper.getPage(req));
    }
}
