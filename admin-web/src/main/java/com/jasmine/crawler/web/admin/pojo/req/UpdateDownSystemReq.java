/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import com.jasmine.crawler.web.admin.validate.annotation.Url;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class UpdateDownSystemReq {

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private Integer priority;

    @ApiModelProperty("")
    private String description;

    @ApiModelProperty("")
    private String appKey;

    @ApiModelProperty("")
    private String appSecret;

    @ApiModelProperty("")
    @Url
    private String dataUrl;

    @ApiModelProperty("")
    private String dataQueue;

    @ApiModelProperty("")
    private Integer taskMaxRunningCount;

    @ApiModelProperty("")
    private Integer taskCurrentRunningCount;

    @ApiModelProperty("")
    private Integer urlTotalCount;

    @ApiModelProperty("")
    private Integer urlFinishedCount;

    @ApiModelProperty("")
    private Integer urlBadCount;

    @ApiModelProperty("")
    @Enum("enableStatus")
    private Integer enableStatus;
}
