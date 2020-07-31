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
public class ScriptDetailResp {

    @ApiModelProperty("i: identifier key")
    private Integer id;

    @ApiModelProperty("script usage")
    private String description;

    @ApiModelProperty("script path")
    private String path;

    @ApiModelProperty("type of script")
    private Integer scriptType;

    @ApiModelProperty("site the script belong to")
    private Integer downSiteId;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("label of enum")
    private String scriptTypeLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
