/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddCookieReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCookiePageReq;

import java.util.List;

public interface CookieService {

    boolean add(AddCookieReq req);

    boolean deleteById(Integer id);

    Cookie getById(Integer id);

    PageResult<Cookie> getPage(GetCookiePageReq req);

    int deleteBatch(List<Integer> ids);
}
