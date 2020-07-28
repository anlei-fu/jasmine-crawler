/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawl.common.pojo.entity.Crawler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CrawlerMapper {

    Crawler getCrawlerBySite(@Param("siteId") Integer siteId);

    void updateConcurrencyById(@Param("id") Integer id, Integer currentConcurrency);

    List<Crawler> getCrawlerNeedHeartbeat();

    void updateHeartbeatStatusById(@Param("id") Integer id, @Param("data") Crawler crawler);

    Crawler getById(@Param("id") int id);
}
