/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.DownSystem;
import com.jasmine.crawler.web.admin.pojo.param.UpdateDownSystemParams;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemPageReq;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface DownSystemMapper {

    int add(AddDownSystemReq req);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateDownSystemParams param);

    DownSystem getById(@Param("id") Integer id);

    Page<DownSystem> getPage(GetDownSystemPageReq req);
}
