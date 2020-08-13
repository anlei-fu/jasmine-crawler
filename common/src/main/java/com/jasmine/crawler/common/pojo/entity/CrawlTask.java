/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrawlTask {
    /**
     * Unique id
     */
    private Integer id;

    /**
     * The down site task belong to
     */
    private Integer downSystemSiteId;

    /**
     * The site task belong to , redundant field
     */
    private Integer siteId;

    /**
     * The system task belong to
     */
    private Integer downSystemId;

    /**
     * Task status , see {@enum TaskStatus}
     */
    private Integer taskStatus;

    private Date taskTimeoutTime;

    private Date bindTimeoutTime;

    // task bind fields

    /**
     * Last bind status  see {@enum BindStatus }
     */
    private Integer bindLastResult;

    /**
     * Last bind time
     */
    private Date bindLastTime;

    /**
     * Last bind msg
     */
    private String bindLastMsg;

    /**
     * The count that task has bind , the lower value, the task get bind more often
     */
    private Integer bindCount;

    // task dispatch fields

    /**
     * Dispatch status see {@enum DispatchStatus}
     */
    private Integer dispatchLastResult;

    /**
     * Dispatch msg
     */
    private String dispatchLastMsg;

    private Date dispatchLastTime;

    // task config fields
    /**
     * The cookie task use ,-1 means not use cookie
     */
    private Integer cookieId;

    /**
     * The proxy task use, -1 means not use proxy
     */
    private Integer proxyId;

    // task result fields

    /**
     * The crawler to run the task
     */
    private Integer crawlerId;

    /**
     * The time task start to run
     */
    private Date taskStartTime;

    /**
     * The task finish time
     */
    private Date taskFinishTime;

    /**
     * The result of the task
     */
    private Integer taskExecuteResultType;

    /**
     * Use for statistics
     */
    private Integer averageSpeedOfAll;

    /**
     * Use for statistics
     */
    private Integer averageSpeedOfSuccess;

    /**
     * The max speed of succeed url ,task result field ,statistics field
     */
    private Integer maxSpeedOfSuccess;

    /**
     * Statistics field
     */
    private Integer meanSpeedOfSuccess;

    /**
     * Task result field
     */
    private Integer failedUrlCount;

    /**
     * Task result field
     */
    private Integer newUrlCount;

    /**
     * Task result field
     */
    private Integer successUrlCount;

    /**
     * The bad urls(404 and other) that crawler detected
     */
    private Integer urlBadCount;

    private Date createTime;
}
