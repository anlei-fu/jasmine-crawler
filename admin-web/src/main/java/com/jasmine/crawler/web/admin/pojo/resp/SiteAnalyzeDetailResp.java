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
public class SiteAnalyzeDetailResp {

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private Integer siteId;

    @ApiModelProperty("")
    private Integer totalCount;

    @ApiModelProperty("")
    private Integer successCount;

    @ApiModelProperty("")
    private Integer successAverageSpeed;

    @ApiModelProperty("")
    private Integer averageSpeed;

    @ApiModelProperty("")
    private Integer blockIpCount;

    @ApiModelProperty("")
    private Integer blockAccountCount;

    @ApiModelProperty("")
    private Integer successMean;

    @ApiModelProperty("")
    private Date createTime;
}
