/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.web.admin.pojo.req.GetCrawlTaskPageReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrawlTaskMapper {

    Page<CrawlTask> getPage(GetCrawlTaskPageReq req);
}
