/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CookieMapper {

    int deleteById(@Param("id") Integer id);

    Cookie get(@Param("id") Integer id);

    Cookie getForSite(@Param("siteId") Integer id);

    void increaseCurrentUseCountById(@Param("id") Integer id);

    void disableInvalidCookies();

    void deleteCookieBatch(@Param("list") List<Integer> cookieIds);

    void decreaseCurrentUseCountById(@Param("id") Integer id);

    void updateDelayTimeout(@Param("id") Integer id);

    List<Cookie> getInvalidCookies();
}
