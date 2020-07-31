/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddDownSystemReq {

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    @NotNull
    private Integer priority;

    @ApiModelProperty("")
    private String description;

    @ApiModelProperty("")
    private String appKey;

    @ApiModelProperty("")
    private String appSecret;

    @ApiModelProperty("")
    private String dataUrl;

    @ApiModelProperty("")
    private String dataQueue;

    @ApiModelProperty("")
    @NotNull
    private Integer taskMaxRunningCount;

    @ApiModelProperty("")
    @Enum("enableStatus")
    private Integer enableStatus;
}
