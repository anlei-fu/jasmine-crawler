package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class SiteIpBlockMap {

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * The site of the rule
     */
    @ApiModelProperty("")
    private Integer siteId;

    /**
     * The ip of the rule
     */
    @ApiModelProperty("")
    private String ip;

    /**
     * The available time that the ip can visit the site
     */
    @ApiModelProperty("")
    private Date blockTimeoutTime;
}
