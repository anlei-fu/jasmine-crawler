/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@ApiModel("task info")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrawlTask  {

    @ApiModelProperty("the average speed of all url")
    private Integer averageSpeedOfAll;

    @ApiModelProperty("the average speed ofsuccess url")
    private Integer averageSpeedOfSuccess;

    @ApiModelProperty("the bad url count")
    private Integer badUrlCount;

    @ApiModelProperty("")
    private String bindErrorMsg;

    @ApiModelProperty("")
    private Integer bindCount;

    @ApiModelProperty("")
    private Integer bindFailedCount;

    @ApiModelProperty("")
    private Integer bindStatus;

    @ApiModelProperty("the crawler which run the task")
    private Integer crawlerId;

    @ApiModelProperty("the time that task created")
    private Date createTime;

    @ApiModelProperty("the site task belong to")
    private Integer downSiteId;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("the url count that crawl failed")
    private Integer failedUrlCount;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private Date lastBindTime;

    @ApiModelProperty("the max speed of all success url")
    private Integer maxSpeedOfSuccess;

    @ApiModelProperty("the mean speed of all url")
    private Integer meanSpeedOfSuccess;

    @ApiModelProperty("the url count that newly detected")
    private Integer newUrlCount;

    @ApiModelProperty("the proxy the task used")
    private Integer proxyId;

    @ApiModelProperty("the account that task used")
    private Integer cookieId;

    @ApiModelProperty("the url count that crawl successfully")
    private Integer successUrlCount;

    @ApiModelProperty("the time that task finished")
    private Date taskEndTime;

    @ApiModelProperty("task execute result")
    private Integer taskExecuteResultType;

    @ApiModelProperty("task status")
    private Integer taskStatus;

    @ApiModelProperty("the time task start to excute")
    private Date taskStartTime;


    private  Integer dispatchStatus;

    private  Date lastDispatchTime;

    private  Integer siteId;
}
