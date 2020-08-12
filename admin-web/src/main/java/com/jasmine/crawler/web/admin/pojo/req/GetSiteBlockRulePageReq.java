/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.pojo.req.PageReq;
import com.jasmine.crawler.common.validate.annotation.Enum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetSiteBlockRulePageReq extends PageReq {

    private Integer siteId;

    @Enum("httpStatus")
    private Integer httpStatus;

    @Enum("checkType")
    private Integer checkType;

    @Enum("pageResultType")
    private Integer pageResultType;

    @Enum("enableStatus")
    private Integer enableStatus;

    private Date createTimeStart;

    private Date createTimeEnd;
}
