/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteBlockRule;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.SiteBlockRuleMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateSiteBlockRuleParams;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteBlockRuleReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteBlockRulePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBlockRuleReq;
import com.jasmine.crawler.web.admin.service.SiteBlockRuleService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteBlockRuleServiceImpl implements SiteBlockRuleService {

    @Autowired
    private SiteBlockRuleMapper siteBlockRuleMapper;

    @Override
    public boolean add(AddSiteBlockRuleReq req) {
        return siteBlockRuleMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return siteBlockRuleMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Integer id, UpdateSiteBlockRuleReq req) {
        UpdateSiteBlockRuleParams params = new UpdateSiteBlockRuleParams(id, req);
        return siteBlockRuleMapper.updateById(params) > 0;
    }

    @Override
    public SiteBlockRule getById(Integer id) {
        return siteBlockRuleMapper.getById(id);
    }

    @Override
    public PageResult<SiteBlockRule> getPage(GetSiteBlockRulePageReq req) {
        return PageHelperUtils.paging(req, () -> siteBlockRuleMapper.getPage(req));
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return siteBlockRuleMapper.deleteBatch(ids);
    }
}
