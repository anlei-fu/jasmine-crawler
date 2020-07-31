/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class DownSystemSiteDetailResp {

    @ApiModelProperty("")
    private Integer id;

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
    private Integer crawlerCrawlType;

    @ApiModelProperty("")
    private Integer crawlerAutoDownloadPage;

    @ApiModelProperty("")
    private Integer urlMaxCacheCount;

    @ApiModelProperty("")
    private Integer urlFinishedCount;

    @ApiModelProperty("")
    private Integer urlBadCount;

    @ApiModelProperty("")
    private Integer urlTotalCount;

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
    private Date bloomLastLoadingTime;

    @ApiModelProperty("")
    private Integer taskUrlBatchCount;

    @ApiModelProperty("")
    private Integer taskMaxWaitToBindCount;

    @ApiModelProperty("")
    private Integer taskCurrentBindCount;

    @ApiModelProperty("")
    private Integer taskMaxRunningCount;

    @ApiModelProperty("")
    private Integer taskCurrentRunningCount;

    @ApiModelProperty("")
    private Integer taskTimeout;

    @ApiModelProperty("")
    private Integer enableStatus;

    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("label of enum")
    private String crawlerCrawlTypeLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
