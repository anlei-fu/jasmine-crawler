/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.SiteBlockRule;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteBlockRuleReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteBlockRulePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBlockRuleReq;

import java.util.List;

public interface SiteBlockRuleService {

    boolean add(AddSiteBlockRuleReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateSiteBlockRuleReq req);

    SiteBlockRule getById(Integer id);

    PageResult<SiteBlockRule> getPage(GetSiteBlockRulePageReq req);

    int deleteBatch(List<Integer> ids);
}
