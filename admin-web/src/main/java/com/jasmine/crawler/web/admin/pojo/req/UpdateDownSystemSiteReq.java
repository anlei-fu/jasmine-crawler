/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class UpdateDownSystemSiteReq {

    @ApiModelProperty("")
    private Integer siteId;

    @ApiModelProperty("")
    private Integer scriptId;

    @ApiModelProperty("")
    private Integer downSystemId;

    @ApiModelProperty("")
    private Integer priority;

    @ApiModelProperty("")
    private String crawlerPageEncoding;

    @ApiModelProperty("")
    private Integer crawlerPageTimeout;

    @ApiModelProperty("")
    @Enum("crawlerCrawlType")
    private Integer crawlerCrawlType;

    @ApiModelProperty("")
    private Integer crawlerAutoDownloadPage;

    @ApiModelProperty("")
    private Integer urlMaxCacheCount;

    @ApiModelProperty("")
    private String urlEncodes;

    @ApiModelProperty("")
    private Integer urlMaxCrawlCount;

    @ApiModelProperty("")
    private String urlMatchPatterns;

    @ApiModelProperty("")
    private Integer bloomExpectedUrlSize;

    @ApiModelProperty("")
    private Float bloomFpp;

    @ApiModelProperty("")
    private Integer taskUrlBatchCount;

    @ApiModelProperty("")
    private Integer taskMaxWaitToBindCount;

    @ApiModelProperty("")
    private Integer taskMaxRunningCount;

    @ApiModelProperty("")
    private Integer taskTimeout;

    @ApiModelProperty("")
    @Enum("enableStatus")
    private Integer enableStatus;
}
