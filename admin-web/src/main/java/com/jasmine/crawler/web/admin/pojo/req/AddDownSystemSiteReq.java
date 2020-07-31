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
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddDownSystemSiteReq {

    @ApiModelProperty("")
    @NotNull
    private Integer siteId;

    @ApiModelProperty("")
    @NotNull
    private Integer scriptId;

    @ApiModelProperty("")
    @NotNull
    private Integer downSystemId;

    @ApiModelProperty("")
    @NotNull
    private Integer priority;

    @ApiModelProperty("")
    private String crawlerPageEncoding;

    @ApiModelProperty("")
    private Integer crawlerPageTimeout;

    @ApiModelProperty("")
    @NotNull
    @Enum("crawlerCrawlType")
    private Integer crawlerCrawlType;

    @ApiModelProperty("")
    @NotNull
    private Integer crawlerAutoDownloadPage;

    @ApiModelProperty("")
    @NotNull
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
    @NotNull
    private Integer taskTimeout;

    @ApiModelProperty("")
    @Enum("enableStatus")
    private Integer enableStatus;
}
