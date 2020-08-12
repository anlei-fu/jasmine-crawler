/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.web.admin.pojo.param.UpdateDownSystemSiteParams;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemSiteBatchReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemSiteMapper {

    int add(AddDownSystemSiteReq req);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateDownSystemSiteParams param);

    DownSystemSite getById(@Param("id") Integer id);

    Page<DownSystemSite> getPage(GetDownSystemSitePageReq req);

    int enableBatch(@Param("list") List<Integer> ids);

    int disableBatch(@Param("list") List<Integer> ids);

    int updateBatch(UpdateDownSystemSiteBatchReq req);
}
