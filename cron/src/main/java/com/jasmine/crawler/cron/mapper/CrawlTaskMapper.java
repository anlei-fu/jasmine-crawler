/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CrawlTaskMapper {

    int add(CrawlTask crawlTask);

    int deleteById(@Param("id") Integer id);

    CrawlTask getById(@Param("id") Integer id);

    List<CrawlTask> getTaskToBind(@Param("minBindCount") Integer minBindCount, @Param("maxBindCount") Integer maxBindCount);

    List<CrawlTask> getTaskToBindLowestLevel();

    void bindFailed(CrawlTask taskToUpdate);

    boolean bindSuccess(@Param("id") Integer id);

    List<CrawlTaskConfig> getTaskConfigsToDispatch();

    int dispatchSuccess(@Param("id") Integer id);

    void dispatchFailed(CrawlTask dispatchFailedTask);

    List<CrawlTask> getTimeoutTasksToTerminate();

    void terminateTimeoutTask(@Param("id") Integer id);

    CrawlTask getForUpdate(@Param("id") Integer id);
}
