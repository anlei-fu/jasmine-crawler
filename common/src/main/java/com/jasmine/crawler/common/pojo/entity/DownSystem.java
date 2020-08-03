package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Getter
@Setter
public class DownSystem extends EnableStatusFeature {

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * The name of down system
     */
    @ApiModelProperty("")
    private String name;

    /**
     * The description of down system
     */
    @ApiModelProperty("")
    private String description;

    /**
     * The priority of down system ,using in task binding rank
     */
    @ApiModelProperty("")
    private Integer priority;

    /**
     * The app key of down system
     */
    @ApiModelProperty("")
    private String appKey;

    /**
     * The app secret of down system
     */
    @ApiModelProperty("")
    private String appSecret;

    /**
     * The web interface to ssend data to down system
     */
    @ApiModelProperty("")
    private String dataUrl;

    /**
     * The queue to send data to down system
     */
    @ApiModelProperty("")
    private String dataQueue;

    /**
     * Max task running conteneously limitation
     */
    @ApiModelProperty("")
    private Integer taskMaxRunningCount;

    /**
     * Current running task count
     */
    @ApiModelProperty("")
    private Integer taskCurrentRunningCount;

    /**
     * Total url count
     */
    @ApiModelProperty("")
    private Integer urlTotalCount;

    /**
     * Finished url count
     */
    @ApiModelProperty("")
    private Integer urlFinishedCount;

    /**
     * Bad url count , bad url (404 ,fake url ....)
     */
    @ApiModelProperty("")
    private Integer urlBadCount;
}
