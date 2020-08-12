/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.Site;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteReq;

public interface SiteService {

    boolean add(AddSiteReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateSiteReq req);

    Site getById(Integer id);

    PageResult<Site> getPage(GetSitePageReq req);

    int updateBatch(UpdateSiteBatchReq req);
}
