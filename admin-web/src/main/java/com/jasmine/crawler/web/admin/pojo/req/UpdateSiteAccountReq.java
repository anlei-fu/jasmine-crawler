/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.*;
import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class UpdateSiteAccountReq {

    @ApiModelProperty("")
    private String nickName;

    @ApiModelProperty("description  of account")
    private String description;

    @ApiModelProperty("")
    @Enum("loginType")
    private Integer loginType;

    @ApiModelProperty("the site that account belong")
    private Integer siteId;

    @ApiModelProperty("the phone of account")
    @Phone
    private String phone;

    @ApiModelProperty("the email of account")
    @Email
    private String email;

    @ApiModelProperty("the password of account")
    @Password
    private String password;

    @ApiModelProperty("the ip that the account last login")
    @Ip
    private String lastLoginIp;

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;
}
