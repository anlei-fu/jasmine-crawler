/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteIpDelayMapPageReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteIpDelayMapMapper {

    Page<SiteIpDelayMap> getPage(GetSiteIpDelayMapPageReq req);

    int deleteById(@Param("id") Integer id);

    int deleteBatch(@Param("list") List<Integer> ids);
}
