/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.DownSystem;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemReq;

public interface DownSystemService {

    boolean add(AddDownSystemReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateDownSystemReq req);

    DownSystem getById(Integer id);

    PageResult<DownSystem> getPage(GetDownSystemPageReq req);

    int updateBatch(UpdateDownSystemBatchReq req);
}
