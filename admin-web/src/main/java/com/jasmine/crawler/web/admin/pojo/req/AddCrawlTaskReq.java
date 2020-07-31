/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
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
public class AddCrawlTaskReq {

    @ApiModelProperty("")
    @NotNull
    private Integer siteId;

    @ApiModelProperty("the site task belong to")
    @NotNull
    private Integer downSystemSiteId;

    @ApiModelProperty("")
    @Enum("taskStatus")
    private Integer taskStatus;

    @ApiModelProperty("task execute result")
    @Enum("taskExecuteResultType")
    private Integer taskExecuteResultType;

    @ApiModelProperty("the crawler which run the task")
    @NotNull
    private Integer crawlerId;

    @ApiModelProperty("")
    @NotNull
    @Enum("bindLastStatus")
    private Integer bindLastStatus;

    @ApiModelProperty("")
    private String bindLastMsg;

    @ApiModelProperty("")
    @NotNull
    private Integer bindCount;

    @ApiModelProperty("task status")
    @Enum("dispatchStatus")
    private Integer dispatchStatus;

    @ApiModelProperty("")
    private String dispatchMsg;

    @ApiModelProperty("")
    @NotNull
    private Integer cookieId;

    @ApiModelProperty("")
    private String cookie;

    @ApiModelProperty("the proxy the task used")
    private Integer proxyId;

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
    @NotNull
    @Enum("enableStatus")
    private Integer enableStatus;
}
