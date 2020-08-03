package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
public class SiteIpDelayMap extends CreateTimeFeature {

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * The ip of the rule
     */
    @ApiModelProperty("")
    private String ip;

    /**
     * The site of the rule
     */
    @ApiModelProperty("")
    private Integer siteId;

    /**
     * The next available time that the ip can visit the site
     */
    @ApiModelProperty("")
    private Date delayTimeoutTime;

}
