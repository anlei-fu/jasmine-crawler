/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.pojo.req.PageReq;
import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class GetSiteBlockRulePageReq extends PageReq {

    @ApiModelProperty("site the rule belong to")
    private Integer siteId;

    @ApiModelProperty("http status code")
    @Enum("httpStatus")
    private Integer httpStatus;

    @ApiModelProperty("checkTyp: json array")
    @Enum("checkType")
    private Integer checkType;

    @ApiModelProperty("if match the page result returned")
    @Enum("pageResultType")
    private Integer pageResultType;

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;

    @ApiModelProperty(" start time")
    private Date createTimeStart;

    @ApiModelProperty(" end time")
    private Date createTimeEnd;
}
