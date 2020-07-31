/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.CookieMapper;
import com.jasmine.crawler.web.admin.pojo.req.AddCookieReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCookiePageReq;
import com.jasmine.crawler.web.admin.service.CookieService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieServiceImpl implements CookieService {

    @Autowired private CookieMapper cookieMapper;

    @Override
    public boolean add(AddCookieReq req) {
        return cookieMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return cookieMapper.deleteById(id) > 0;
    }

    @Override
    public Cookie getById(Integer id) {
        return cookieMapper.getById(id);
    }

    @Override
    public PageResult<Cookie> getPage(GetCookiePageReq req) {
        return PageHelperUtils.paging(req, () -> cookieMapper.getPage(req));
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return cookieMapper.deleteBatch(ids);
    }
}
