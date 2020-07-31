/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.ProxyMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateProxyParams;
import com.jasmine.crawler.web.admin.pojo.req.AddProxyReq;
import com.jasmine.crawler.web.admin.pojo.req.GetProxyPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateProxyReq;
import com.jasmine.crawler.web.admin.service.ProxyService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired private ProxyMapper proxyMapper;

    @Override
    public boolean add(AddProxyReq req) {
        return proxyMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return proxyMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Integer id, UpdateProxyReq req) {
        UpdateProxyParams params = new UpdateProxyParams(id, req);
        return proxyMapper.updateById(params) > 0;
    }

    @Override
    public Proxy getById(Integer id) {
        return proxyMapper.getById(id);
    }

    @Override
    public PageResult<Proxy> getPage(GetProxyPageReq req) {
        return PageHelperUtils.paging(req, () -> proxyMapper.getPage(req));
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return proxyMapper.deleteBatch(ids);
    }

    @Override
    public int disableBatch(List<Integer> ids) {
        return proxyMapper.disableBatch(ids);
    }

    @Override
    public int enableBatch(List<Integer> ids) {
        return proxyMapper.enableBatch(ids);
    }
}
