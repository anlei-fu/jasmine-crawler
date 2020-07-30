/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProxyMapper {

    Proxy getProxyForSite(@Param("siteId") Integer siteId);

    int increaseCurrentUseCountById(@Param("id") Integer id);

    void decreaseCurrentUseCountById(@Param("id") Integer id);

    Proxy getById(@Param("id") Integer id);

    void disableBlockedProxies();

}
