package com.jasmine.crawler.cron.pojo.config;

import com.jasmine.crawl.common.pojo.entity.Proxy;
import lombok.Data;

@Data
public class CrawlTaskConfig {

    /***
     * The crawl task type see {@enum CrawlType}
     */
    private Integer crawlType;

    /**
     * Determine if auto download page and check page result
     * if pass through html directly ,or download and check result by self
     */
    private Integer autoDownloadPage;

    /**
     * The encoding of target site
     */
    private String encoding;

    /**
     * Download page timeout
     */
    private Integer timeout;

    /**
     * Task id
     */
    private Integer taskId;

    /**
     * Down system site id
     */
    private Integer downSystemSiteId;

    /**
     * Target site id
     */
    private Integer siteId;

    /**
     * The proxy config ,'-1' not use proxy
     */
    private Integer proxyId;

    /**
     * Proxy info see {@Type Poxy}
     */
    private Proxy proxy;

    /**
     * The cookie
     */
    private Integer cookieId;

    /**
     * cookie in json string
     */
    private String cookie;

    private String blockRules;

    /**
     * Task max concurrency
     */
    private Integer maxConcurrency;

    /**
     * Task timeout
     */
    private Integer taskTimeout;

    // json string array
    private String urlMatchPatterns;

    // json string array
    private String urlEncodes;

    private Integer crawlerId;

}
