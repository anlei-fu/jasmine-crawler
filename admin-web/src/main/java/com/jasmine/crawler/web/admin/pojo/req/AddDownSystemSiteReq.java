/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Enum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddDownSystemSiteReq {

    @NotNull
    private Integer siteId;

    @NotNull
    private Integer downSystemId;

    private Integer priority;

    private Integer scriptId;

    private String crawlerPageEncoding;

    private Integer crawlerPageTimeout;

    @Enum("crawlerCrawlType")
    private Integer crawlerCrawlType;

    private Integer crawlerAutoDownloadPage;

    private Integer urlMaxCacheCount;

    private String urlEncodes;

    /**
     * Url max retry
     */
    private Integer urlMaxCrawlCount;

    private Integer urlMaxDepth;

    private String urlMatchPatterns;

    private Integer bloomExpectedUrlSize;

    private Float bloomFpp;

    private Integer taskUrlBatchCount;

    private Integer taskMaxWaitToBindCount;

    private Integer taskMaxRunningCount;

    private Integer taskTimeout;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
