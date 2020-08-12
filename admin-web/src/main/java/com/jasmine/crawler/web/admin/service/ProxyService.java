/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddProxyReq;
import com.jasmine.crawler.web.admin.pojo.req.GetProxyPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateProxyBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateProxyReq;

import java.util.List;

public interface ProxyService {

    boolean add(AddProxyReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateProxyReq req);

    Proxy getById(Integer id);

    PageResult<Proxy> getPage(GetProxyPageReq req);

    int enableBatch(List<Integer> ids);

    int disableBatch(List<Integer> ids);

    int deleteBatch(List<Integer> ids);

    int updateBatch(UpdateProxyBatchReq req);
}
