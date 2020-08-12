/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteIpBlockMapPageReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteIpBlockMapMapper {

    Page<SiteIpBlockMap> getPage(GetSiteIpBlockMapPageReq req);

    int deleteBatch(@Param("list") List<Integer> ids);
}
