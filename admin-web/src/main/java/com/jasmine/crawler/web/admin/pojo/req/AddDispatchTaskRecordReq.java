/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddDispatchTaskRecordReq {

    @ApiModelProperty("")
    private Integer crawlTaskId;

    @ApiModelProperty("")
    @Enum("dispatchStatus")
    private Integer dispatchStatus;

    @ApiModelProperty("")
    private String dispatchMsg;

    @ApiModelProperty("")
    private String createTime;
}