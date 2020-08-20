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

@Getter
@Setter
public class UpdateDownSystemSiteReq {

    private Integer siteId;

    private String scriptPath;

    private Integer downSystemId;

    private Integer priority;

    private String crawlerPageEncoding;

    private Integer crawlerPageTimeout;

    @Enum("CrawlerCrawlType")
    private Integer crawlerCrawlType;

    private Integer crawlerAutoDownloadPage;

    private Integer urlMaxCacheCount;

    private String urlEncodes;

    private Integer urlMaxCrawlCount;

    private Integer urlMaxDepth;

    private String urlMatchPatterns;

    private Integer taskUrlBatchCount;

    private Integer taskMaxCount;

    private Integer taskMaxRunningCount;

    private Integer taskTimeout;

    private Integer taskBindTimeout;

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

    private Integer bloomExpectedUrlSize;

    private Integer bloomFpp;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
