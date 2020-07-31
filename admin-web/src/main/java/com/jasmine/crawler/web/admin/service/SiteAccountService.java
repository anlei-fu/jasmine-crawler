/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteAccountReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteAccountPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountReq;
import java.util.List;

public interface SiteAccountService {

    boolean add(AddSiteAccountReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateSiteAccountReq req);

    SiteAccount getById(Integer id);

    PageResult<SiteAccount> getPage(GetSiteAccountPageReq req);

    int deleteBatch(List<Integer> ids);

    int disableBatch(List<Integer> ids);

    int enableBatch(List<Integer> ids);
}
