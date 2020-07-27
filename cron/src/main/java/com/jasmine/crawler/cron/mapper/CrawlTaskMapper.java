/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import com.jasmine.crawler.cron.pojo.entity.CrawlTask;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CrawlTaskMapper {

    int add(CrawlTask crawlTask);

    int deleteById(@Param("id") Integer id);

    int updateById(@Param("id") Integer id,@Param("task") CrawlTask crawlTask);

    CrawlTask getById(@Param("id") Integer id);

    List<CrawlTaskConfig> getTaskConfigToRun();

    List<CrawlTask> getTaskToBind(@Param("level") Integer level);
}
