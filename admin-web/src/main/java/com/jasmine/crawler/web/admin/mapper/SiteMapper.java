/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.Site;
import com.jasmine.crawler.web.admin.pojo.param.UpdateSiteParams;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBatchReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SiteMapper {

    int add(AddSiteReq req);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateSiteParams param);

    Site getById(@Param("id") Integer id);

    Page<Site> getPage(GetSitePageReq req);

    int updateBatch(UpdateSiteBatchReq req);
}
