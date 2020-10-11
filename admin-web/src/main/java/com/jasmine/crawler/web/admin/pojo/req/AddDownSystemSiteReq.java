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

    private  Integer id;

    @NotNull
    private Integer siteId;

    @NotNull
    private Integer downSystemId;

    private  String name ;

    private  String description;

    private  Integer downSystemSiteType;

    private Integer priority;

    private String scriptPath;

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

    private String bloom;

    private Integer taskUrlBatchCount;

    private Integer taskMaxCount;

    private Integer taskBindTimeout;

    private Integer taskMaxRunningCount;

    private Integer taskTimeout;

    /**
     * Max fail count of a task
     */
    private Integer taskUrlMaxFailCount;

    /**
     * Max continuously fail count of a task
     */
    private Integer taskUrlMaxContinuouslyFailCount;

    /**
     * Max concurrent executing count of url
     */
    private Integer taskUrlMaxConcurrency;

    @Enum("EnableStatus")
    private Integer enableStatus;

    private  Integer runLimitAllowAutoBalance;

    private  Integer runLimitMaxDays;

    private  Integer runLimitMaxHours;
}
