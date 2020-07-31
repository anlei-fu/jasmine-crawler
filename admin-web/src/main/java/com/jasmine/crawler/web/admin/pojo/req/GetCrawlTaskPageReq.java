/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.pojo.req.PageReq;
import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class GetCrawlTaskPageReq extends PageReq {

    @ApiModelProperty("")
    private Integer siteId;

    @ApiModelProperty("the site task belong to")
    private Integer downSystemSiteId;

    @ApiModelProperty("")
    @Enum("taskStatus")
    private Integer taskStatus;

    @ApiModelProperty("task execute result")
    @Enum("taskExecuteResultType")
    private Integer taskExecuteResultType;

    @ApiModelProperty("the crawler which run the task")
    private Integer crawlerId;

    @ApiModelProperty("")
    @Enum("bindLastStatus")
    private Integer bindLastStatus;

    @ApiModelProperty("task status")
    @Enum("dispatchStatus")
    private Integer dispatchStatus;

    @ApiModelProperty("")
    private Integer cookieId;

    @ApiModelProperty("the proxy the task used")
    private Integer proxyId;

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;

    @ApiModelProperty("the time that task created start time")
    private Date createTimeStart;

    @ApiModelProperty("the time that task created end time")
    private Date createTimeEnd;
}
