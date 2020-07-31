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
public class DownSystemDetailResp {

    @ApiModelProperty("")
    private Integer id;

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
    private Integer enableStatus;

    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
