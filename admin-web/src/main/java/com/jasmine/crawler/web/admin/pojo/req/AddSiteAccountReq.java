/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Email;
import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Ip;
import com.jasmine.crawler.common.validate.annotation.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddSiteAccountReq {

    @NotNull
    private Integer siteId;

    @NotNull
    private String account;

    private String nickName;

    private String description;

    @Enum("YesNo")
    private Integer validated;

    @Enum("AccountType")
    private Integer accountType;

    @Enum("loginType")
    private Integer loginType;

    @Phone
    private String phone;

    @Email
    private String email;

    private String password;

    @Ip
    private String lastLoginIp;

    @Enum("enableStatus")
    private Integer enableStatus;
}
