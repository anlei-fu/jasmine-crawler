/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.web.admin.mapper.UrlMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateParams;
import com.jasmine.crawler.web.admin.pojo.req.AddSeedUrlReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;
import com.jasmine.crawler.web.admin.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public boolean add(AddSeedUrlReq req) {
        return urlMapper.add(req) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return urlMapper.delete(id) > 0;
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
    public List<Url> getPage(Integer downSystemSiteId) {
        return urlMapper.getSeedUrlByDownSystemSiteId(downSystemSiteId);
    }
}
