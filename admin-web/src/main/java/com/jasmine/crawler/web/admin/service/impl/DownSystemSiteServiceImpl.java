/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.component.impl.JasmineBloomFilterImpl;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateDownSystemSiteParams;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemSiteBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemSiteReq;
import com.jasmine.crawler.web.admin.service.DownSystemSiteService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DownSystemSiteServiceImpl implements DownSystemSiteService {

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Override
    public boolean add(AddDownSystemSiteReq req) throws IOException {
        JasmineBloomFilter bloomFilter = new JasmineBloomFilterImpl();
        bloomFilter.init(req.getBloomExpectedUrlSize(), req.getBloomFpp());
        req.setBloom(bloomFilter.dump());
        return downSystemSiteMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return downSystemSiteMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Integer id, UpdateDownSystemSiteReq req) {
        UpdateDownSystemSiteParams params = new UpdateDownSystemSiteParams(id, req);
        return downSystemSiteMapper.updateById(params) > 0;
    }

    @Override
    public DownSystemSite getById(Integer id) {
        return downSystemSiteMapper.getById(id);
    }

    @Override
    public PageResult<DownSystemSite> getPage(GetDownSystemSitePageReq req) {
        return PageHelperUtils.paging(req, () -> downSystemSiteMapper.getPage(req));
    }

    @Override
    public int enableBatch(List<Integer> ids) {
        return downSystemSiteMapper.enableBatch(ids);
    }

    @Override
    public int disableBatch(List<Integer> ids) {
        return downSystemSiteMapper.disableBatch(ids);
    }

    @Override
    public int updateBatch(UpdateDownSystemSiteBatchReq req) {
        return downSystemSiteMapper.updateBatch(req);
    }
}
