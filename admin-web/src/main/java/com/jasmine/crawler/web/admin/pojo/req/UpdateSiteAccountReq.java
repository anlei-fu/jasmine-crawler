/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Email;
import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Phone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSiteAccountReq {

    private String account;

    private String nickName;

    @Enum("YesNo")
    private Integer validated;

    @Enum("AccountType")
    private Integer accountType;

    private String description;

    @Enum("loginType")
    private Integer loginType;

    private Integer siteId;

    @Phone
    private String phone;

    @Email
    private String email;

    private String password;

    @Enum("enableStatus")
    private Integer enableStatus;
}
