/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.SiteAccountMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateSiteAccountParams;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteAccountReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteAccountPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountReq;
import com.jasmine.crawler.web.admin.service.SiteAccountService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteAccountServiceImpl implements SiteAccountService {

    @Autowired
    private SiteAccountMapper siteAccountMapper;

    @Override
    public boolean add(AddSiteAccountReq req) {
        return siteAccountMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return siteAccountMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Integer id, UpdateSiteAccountReq req) {
        UpdateSiteAccountParams params = new UpdateSiteAccountParams(id, req);
        return siteAccountMapper.updateById(params) > 0;
    }

    @Override
    public SiteAccount getById(Integer id) {
        return siteAccountMapper.getById(id);
    }

    @Override
    public PageResult<SiteAccount> getPage(GetSiteAccountPageReq req) {
        return PageHelperUtils.paging(req, () -> siteAccountMapper.getPage(req));
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return siteAccountMapper.deleteBatch(ids);
    }

    @Override
    public int disableBatch(List<Integer> ids) {
        return siteAccountMapper.disableBatch(ids);
    }

    @Override
    public int enableBatch(List<Integer> ids) {
        return siteAccountMapper.enableBatch(ids);
    }

    @Override
    public int updateBatch(UpdateSiteAccountBatchReq req) {
        return siteAccountMapper.updateBatch(req);
    }

    @Override
    public List<SiteAccount> getAccountBySiteId(Integer siteId) {
        return siteAccountMapper.getAccountBySiteId(siteId);
    }
}
