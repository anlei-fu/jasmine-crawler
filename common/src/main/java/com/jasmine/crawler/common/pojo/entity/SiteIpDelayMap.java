package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

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
