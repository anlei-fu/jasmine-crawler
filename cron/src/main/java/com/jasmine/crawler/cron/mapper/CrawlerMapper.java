/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.Crawler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CrawlerMapper {

    List<Crawler> getCrawlerForSite(
            @Param("siteId") Integer siteId,
            @Param("taskUrlMaxConcurrency") Integer taskUrlMaxConcurrency,
            @Param("withIp") boolean withIp);

    void updateConcurrencyById(@Param("id") Integer id, @Param("concurrencyToIncrease") Integer concurrencyToIncrease);

    List<Crawler> getCrawlersNeedHeartbeat();

    Crawler getById(@Param("id") int id);

    void heartbeatSuccess(@Param("id") Integer id);

    void heartbeatFailed(Integer crawlerId);
}
