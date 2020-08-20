/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:06:21 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.resp;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.api.req.PageReq;
import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Integer pageIndex;
    private Integer pageSize;
    private Long total;
    private List<T> list;

    public static <T> PageResult<T> create(PageReq req, Page<T> page) {
        PageResult<T> result = new PageResult<>();
        result.list = page.getResult();
        result.total = page.getTotal();
        result.pageIndex = req.getPageIndex();
        result.pageSize = req.getPageSize();
        return result;
    }
}
