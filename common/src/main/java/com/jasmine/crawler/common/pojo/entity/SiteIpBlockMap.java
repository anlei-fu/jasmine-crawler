package com.jasmine.crawler.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiteIpBlockMap {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * The site of the rule
     */
    private Integer siteId;

    /**
     * The ip of the rule
     */
    private String ip;

    /**
     * The available time that the ip can visit the site
     */
    private Date blockTimeoutTime;
}
