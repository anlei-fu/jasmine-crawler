/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-4-18 4:54:16 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jasmine.crawler.common.api.req.PageReq;
import com.jasmine.crawler.common.pojo.resp.PageResult;

import java.util.function.Supplier;

public class PageHelperUtils {

    public static <T> PageResult<T> paging(PageReq req, Supplier<Page<T>> supplier) {
        startPage(req);
        return PageResult.create(req, supplier.get());
    }

    public static void startPage(PageReq req) {
        PageHelper.startPage(req.getPageIndex(), req.getPageSize());
    }
}
