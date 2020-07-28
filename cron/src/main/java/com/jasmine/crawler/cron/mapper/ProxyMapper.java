/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawl.common.pojo.entity.Proxy;
import org.mapstruct.Mapper;

@Mapper
public interface ProxyMapper {

    Proxy getProxyBySiteId(Integer siteId);

    int increaseCurrentUseCountById(Integer id);

    void decreaseCurrentUseCountById(Integer id);

    Proxy getById(Integer id);
}
