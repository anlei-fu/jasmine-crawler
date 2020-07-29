/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawl.common.pojo.entity.Site;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface SiteMapper {

    Site getById(@Param("id") Integer id);

    void increaseTaskRunningCountById(@Param("id") Integer id);

    void decreaseCurrentRunningTaskCountById(@Param("id") Integer id);
}
