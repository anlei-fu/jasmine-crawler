/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import com.jasmine.crawl.common.pojo.entity.CrawlTask;

import java.util.List;

public interface CrawlTaskService {

    List<CrawlTask> getTaskToBind( Integer level);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, CrawlTask updateCrawlTaskReq);

    boolean add(CrawlTask taskToCreate);

    List<CrawlTaskConfig> getTaskConfigToRun();

    List<CrawlTask> getTasksToTerminate();
}
