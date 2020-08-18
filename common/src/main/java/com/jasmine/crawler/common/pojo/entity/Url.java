package com.jasmine.crawler.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Url extends EnableStatusFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * Down site id of url
     */
    private Integer downSystemSiteId;

    /**
     * Url
     */
    private String url;

    /**
     * Refer url
     */
    private String referUrl;

    /**
     * Url type see {@enum UrlType}
     */
    private Integer urlType;

    /**
     * Url status see {@enum UrlStatus}
     */
    private Integer urlStatus;

    /**
     * Priority of url
     */
    private  Integer priority;

    /**
     * The http method for url see {@enum HttpMethod}
     */
    private  Integer httpMethod;

    /**
     * The depth of the url
     */
    private Integer depth;

    /**
     * Query parameters of url
     */
    private String query;

    /**
     * Params json string
     */
    private String params;

    /**
     * Crawl count
     */
    private Integer totalCrawlCount;

    /**
     * Total count of success
     */
    private  Integer totalSuccessCount;

    /**
     * Error msg
     */
    private String lastCrawlMsg;

    /**
     * Last crawl time
     */
    private Date lastCrawlTime;

    /**
     * Last success time
     */
    private Date lastSuccessTime;

}
