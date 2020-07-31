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
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class UpdateCookieReq {

    @ApiModelProperty("")
    private Integer siteId;

    @ApiModelProperty("")
    private Integer siteAccountId;

    @ApiModelProperty("")
    private String cookie;

    @ApiModelProperty("")
    @Ip
    private String loginIp;

    @ApiModelProperty("")
    private Integer currentBlockCount;

    @ApiModelProperty("")
    private Integer currentUseCount;

    @ApiModelProperty("")
    private Date expireTime;
}
