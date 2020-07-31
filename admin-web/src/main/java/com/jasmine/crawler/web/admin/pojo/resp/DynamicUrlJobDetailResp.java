/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class DynamicUrlJobDetailResp {

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private Integer downSystemId;

    @ApiModelProperty("")
    private Integer scriptId;

    @ApiModelProperty("")
    private Integer dynamicType;

    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("")
    private Integer enableStatus;

    @ApiModelProperty("")
    private Integer delayTimeout;

    @ApiModelProperty("")
    private Date lastRunTime;

    @ApiModelProperty("")
    private Integer concurrency;

    @ApiModelProperty("")
    private Integer maxWaintToBindTaskCount;

    @ApiModelProperty("label of enum")
    private String dynamicTypeLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
