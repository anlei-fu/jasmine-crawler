package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiteIpDelayMap {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * The ip of the rule
     */
    private String ip;

    /**
     * The site of the rule
     */
    private Integer siteId;

    /**
     * The next available time that the ip can visit the site
     */
    private Date delayTimeoutTime;

}
