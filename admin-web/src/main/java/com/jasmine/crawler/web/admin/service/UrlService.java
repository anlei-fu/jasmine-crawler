/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddUrlReq;
import com.jasmine.crawler.web.admin.pojo.req.GetUrlPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;

public interface UrlService {

    boolean add(AddUrlReq req);

    boolean deleteByUrl(String url);

    boolean updateByUrl(String url, UpdateUrlReq req);

    Url getByUrl(String url);

    PageResult<Url> getPage(GetUrlPageReq req);
}
