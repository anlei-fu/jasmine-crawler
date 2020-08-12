package com.jasmine.crawler.common.pojo.entity;

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
    private Integer id;

    /**
     * The name of down system
     */
    private String name;

    /**
     * The description of down system
     */
    private String description;

    /**
     * The priority of down system ,using in task binding rank
     */
    private Integer priority;

    /**
     * The app key of down system
     */
    private String appKey;

    /**
     * The app secret of down system
     */
    private String appSecret;

    /**
     * The web interface to ssend data to down system
     */
    private String dataUrl;

    /**
     * The queue to send data to down system
     */
    private String dataQueue;

    /**
     * Max task running conteneously limitation
     */
    private Integer taskMaxRunningCount;

    /**
     * Current running task count
     */
    private Integer taskCurrentRunningCount;

    /**
     * Total url count
     */
    private Integer urlTotalCount;

    /**
     * Finished url count
     */
    private Integer urlFinishedCount;

    /**
     * Bad url count , bad url (404 ,fake url ....)
     */
    private Integer urlBadCount;
}
