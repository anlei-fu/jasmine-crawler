/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.PageTimeReq;
import com.jasmine.crawler.common.validate.annotation.Enum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCrawlTaskPageReq extends PageTimeReq {

    private Integer siteId;

    private Integer downSystemId;

    @Enum("taskStatus")
    private Integer taskStatus;

    @Enum("taskExecuteResultType")
    private Integer taskExecuteResultType;

    private Integer crawlerId;

    @Enum("bindLastStatus")
    private Integer bindLastStatus;

    @Enum("dispatchStatus")
    private Integer dispatchStatus;

    private Integer cookieId;

    private Integer proxyId;

    @Enum("enableStatus")
    private Integer enableStatus;

}
