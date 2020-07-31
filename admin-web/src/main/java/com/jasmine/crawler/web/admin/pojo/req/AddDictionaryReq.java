/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddDictionaryReq {

    @ApiModelProperty("type of enum,not null")
    @NotNull
    private String type;

    @ApiModelProperty("value of enum ,not null")
    @NotNull
    private Integer value;

    @ApiModelProperty("label of enum")
    @NotNull
    private String label;
}
