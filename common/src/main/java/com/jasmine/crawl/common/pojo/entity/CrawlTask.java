/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawl.common.pojo.entity;

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

    /**
     * Use for statistics
     */
    @ApiModelProperty("the average speed of all url")
    private Integer averageSpeedOfAll;

    /**
     * Use for statistics
     */
    @ApiModelProperty("the average speed ofsuccess url")
    private Integer averageSpeedOfSuccess;

    /**
     * The bad urls(404 and other) that crawler detected
     */
    @ApiModelProperty("the bad url count")
    private Integer badUrlCount;

    /**
     * Last bind msg
     */
    @ApiModelProperty("")
    private String lastBindMsg;

    /**
     * The count that task has bind , the lower value, the task get bind more often
     */
    @ApiModelProperty("")
    private Integer bindCount;

    /**
     * Last bind status  see {@enum BindStatus }
     */
    @ApiModelProperty("")
    private Integer bindStatus;

    /**
     * The crawler to run the task
     */
    @ApiModelProperty("the crawler which run the task")
    private Integer crawlerId;

    /**
     * Create time
     */
    @ApiModelProperty("the time that task created")
    private Date createTime;

    /**
     * The down site task belong to
     */
    @ApiModelProperty("the site task belong to")
    private Integer downSiteId;

    /**
     * Task result field
     */
    @ApiModelProperty("the url count that crawl failed")
    private Integer failedUrlCount;

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * Last bind time
     */
    @ApiModelProperty("")
    private Date lastBindTime;

    /**
     * The max speed of succeed url ,task result field ,statistics field
     */
    @ApiModelProperty("the max speed of all success url")
    private Integer maxSpeedOfSuccess;

    /**
     * Statistics field
     */
    @ApiModelProperty("the mean speed of all url")
    private Integer meanSpeedOfSuccess;

    /**
     * Task result field
     */
    @ApiModelProperty("the url count that newly detected")
    private Integer newUrlCount;

    /**
     * The proxy task use, -1 means not use proxy
     */
    @ApiModelProperty("the proxy the task used")
    private Integer proxyId;

    /**
     * The cookie task use ,-1 means not use cookie
     */
    @ApiModelProperty("the account that task used")
    private Integer cookieId;

    /**
     * Task result field
     */
    @ApiModelProperty("the url count that crawl successfully")
    private Integer successUrlCount;

    /**
     * Task finish time
     */
    @ApiModelProperty("the time that task finished")
    private Date taskFinishTime;


    @ApiModelProperty("task execute result")
    private Integer taskExecuteResultType;

    /**
     * Task status , see {@enum TaskStatus}
     */
    @ApiModelProperty("task status")
    private Integer taskStatus;

    /**
     * The time task start to run
     */
    @ApiModelProperty("the time task start to excute")
    private Date taskStartTime;

    /**
     * Dispatch status see {@enum DispatchStatus}
     */
    private  Integer dispatchStatus;

    /**
     * The site task belong to
     */
    private  Integer siteId;
}
