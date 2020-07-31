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
public class CrawlTaskDetailResp {

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private Integer siteId;

    @ApiModelProperty("the site task belong to")
    private Integer downSystemSiteId;

    @ApiModelProperty("")
    private Date taskTimeoutTime;

    @ApiModelProperty("")
    private Integer taskStatus;

    @ApiModelProperty("task execute result")
    private Integer taskExecuteResultType;

    @ApiModelProperty("the crawler which run the task")
    private Integer crawlerId;

    @ApiModelProperty("")
    private Integer bindLastStatus;

    @ApiModelProperty("")
    private String bindLastMsg;

    @ApiModelProperty("")
    private Date bindLastTime;

    @ApiModelProperty("")
    private Integer bindCount;

    @ApiModelProperty("task status")
    private Integer dispatchStatus;

    @ApiModelProperty("")
    private Date dispatchTime;

    @ApiModelProperty("")
    private String dispatchMsg;

    @ApiModelProperty("")
    private Integer cookieId;

    @ApiModelProperty("")
    private String cookie;

    @ApiModelProperty("the proxy the task used")
    private Integer proxyId;

    @ApiModelProperty("the time task start to excute")
    private Date taskStartTime;

    @ApiModelProperty("the time that task finished")
    private Date taskFinishTime;

    @ApiModelProperty("the url count that crawl successfully")
    private Integer successUrlCount;

    @ApiModelProperty("the url count that crawl failed")
    private Integer urlFailedCount;

    @ApiModelProperty("the url count that newly detected")
    private Integer urlNewCount;

    @ApiModelProperty("the bad url count")
    private Integer urlBadCount;

    @ApiModelProperty("the average speed of all url")
    private Integer averageSpeedOfAll;

    @ApiModelProperty("the average speed ofsuccess url")
    private Integer averageSpeedOfSuccess;

    @ApiModelProperty("the mean speed of all url")
    private Integer meanSpeedOfSuccess;

    @ApiModelProperty("the max speed of all success url")
    private Integer maxSpeedOfSuccess;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("the time that task created")
    private Date createTime;

    @ApiModelProperty("the name of crawler")
    private String crawlerName;

    @ApiModelProperty("the name of site")
    private String siteName;

    @ApiModelProperty("the type of proxy")
    private Integer proxyType;

    @ApiModelProperty("")
    private String siteAccountNickName;

    @ApiModelProperty("label of enum")
    private String taskStatusLabel;

    @ApiModelProperty("label of enum")
    private String taskExecuteResultTypeLabel;

    @ApiModelProperty("label of enum")
    private String bindLastStatusLabel;

    @ApiModelProperty("label of enum")
    private String dispatchStatusLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
