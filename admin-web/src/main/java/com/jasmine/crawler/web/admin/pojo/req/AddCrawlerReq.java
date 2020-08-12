/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Ip;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddCrawlerReq {

    @NotNull
    private String uniqueId;

    @NotNull
    private String name;

    @NotNull
    @Ip
    private String ip;

    @NotNull
    private Integer port;

    private String clientVersion;

    private String description;

    @Enum("CrawlerType")
    private Integer crawlerType;

    private String key;

    private Integer maxConcurrency;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
