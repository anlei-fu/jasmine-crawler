/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import com.jasmine.crawler.web.admin.validate.annotation.Path;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddScriptReq {

    @ApiModelProperty("script usage")
    private String description;

    @ApiModelProperty("script path")
    @NotNull
    @Path
    private String path;

    @ApiModelProperty("type of script")
    @Enum("scriptType")
    private Integer scriptType;

    @ApiModelProperty("site the script belong to")
    @NotNull
    private Integer downSiteId;

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;
}
