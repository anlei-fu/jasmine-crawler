/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.Script;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddScriptReq;
import com.jasmine.crawler.web.admin.pojo.req.GetScriptPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateScriptReq;

public interface ScriptService {

    boolean add(AddScriptReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateScriptReq req);

    Script getById(Integer id);

    PageResult<Script> getPage(GetScriptPageReq req);
}
