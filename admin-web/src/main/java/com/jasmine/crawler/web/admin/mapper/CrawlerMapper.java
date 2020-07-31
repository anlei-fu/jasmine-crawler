/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.web.admin.pojo.param.UpdateCrawlerParams;
import com.jasmine.crawler.web.admin.pojo.req.AddCrawlerReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCrawlerPageReq;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface CrawlerMapper {

    int add(AddCrawlerReq req);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateCrawlerParams param);

    Crawler getById(@Param("id") Integer id);

    Page<Crawler> getPage(GetCrawlerPageReq req);

    int deleteBatch(@Param("list") List<Integer> ids);

    int disableBatch(@Param("list") List<Integer> ids);

    int enableBatch(@Param("list") List<Integer> ids);
}
