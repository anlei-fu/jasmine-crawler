/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemSiteBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemSiteReq;

import java.io.IOException;
import java.util.List;

public interface DownSystemSiteService {

    boolean add(AddDownSystemSiteReq req) throws IOException;

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateDownSystemSiteReq req);

    DownSystemSite getById(Integer id);

    PageResult<DownSystemSite> getPage(GetDownSystemSitePageReq req);

    int enableBatch(List<Integer> ids);

    int disableBatch(List<Integer> ids);

    int updateBatch(UpdateDownSystemSiteBatchReq req);
}
