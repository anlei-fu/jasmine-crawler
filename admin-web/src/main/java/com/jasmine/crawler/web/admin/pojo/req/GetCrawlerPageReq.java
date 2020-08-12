/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.pojo.req.PageTimeReq;
import com.jasmine.crawler.common.validate.annotation.Enum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCrawlerPageReq extends PageTimeReq {

    @Enum("CrawlerType")
    private Integer crawlerType;

    @Enum("HeartbeatStatus")
    private Integer heartbeatStatus;

    @Enum("EnableStatus")
    private Integer enableStatus;

    private String name;

    private String ip;

    private String clientVersion;

}
