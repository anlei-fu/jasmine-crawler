/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.Script;
import com.jasmine.crawler.web.admin.pojo.param.UpdateScriptParams;
import com.jasmine.crawler.web.admin.pojo.req.AddScriptReq;
import com.jasmine.crawler.web.admin.pojo.req.GetScriptPageReq;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface ScriptMapper {

    int add(AddScriptReq req);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateScriptParams param);

    Script getById(@Param("id") Integer id);

    Page<Script> getPage(GetScriptPageReq req);
}
