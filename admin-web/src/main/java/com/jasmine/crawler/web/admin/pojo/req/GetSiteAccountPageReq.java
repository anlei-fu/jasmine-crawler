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
public class GetSiteAccountPageReq extends PageTimeReq {

    @Enum("loginType")
    private Integer loginType;

    @Enum("AccountType")
    private Integer accountType;

    @Enum("YesNo")
    private Integer validated;

    private Integer siteId;

    @Enum("enableStatus")
    private Integer enableStatus;

    private String account;

    private String email;

    private String phone;

}
