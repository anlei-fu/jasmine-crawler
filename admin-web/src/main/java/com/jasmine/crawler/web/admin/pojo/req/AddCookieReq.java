/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Ip;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddCookieReq {

    @ApiModelProperty("")
    @NotNull
    private Integer siteId;

    @ApiModelProperty("")
    @NotNull
    private Integer siteAccountId;

    @ApiModelProperty("")
    @NotNull
    private String cookie;

    @ApiModelProperty("")
    @Ip
    private String loginIp;

    private Date expireTime;
}