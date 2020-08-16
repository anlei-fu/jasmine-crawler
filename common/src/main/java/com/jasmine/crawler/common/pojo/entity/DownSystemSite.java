package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

/**
 * Model of down system site
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DownSystemSite extends EnableStatusFeature {
    /**
     * Unique key
     */
    private Integer id;

    /**
     * Target site
     */
    private Integer siteId;

    /**
     * The Down system the site belong to
     */
    private Integer downSystemId;

    /**
     * The script to run crawl task
     */
    private String scriptPath;

    /**
     * Priority of the site , use for task binding rank
     */
    private Integer priority;

    /**
     * The encoding of target site
     */
    private String crawlerPageEncoding;

    /**
     * The download page timeout of target site
     */
    private Integer crawlerPageTimeout;

    /**
     * Crawl type see {@enum CrawlType}
     */
    private Integer crawlerCrawlType;

    /**
     * Determine if the crawler worker auto download page ,
     * or download page by self int crawl script
     */
    private Integer crawlerAutoDownloadPage;

    /**
     * The threshold that max url count to cache in url queue
     */
    private Integer urlMaxCacheCount;

    /**
     * The total count of unique url that has been found
     */
    private Integer urlTotalCount;

    /**
     * The count of url that has been crawled successfully
     */
    private Integer urlFinishedCount;

    /**
     * The bad url count of target site
     */
    private Integer urlBadCount;

    /**
     * The url encodes in json array format
     */
    private String urlEncodes;

    /**
     * The url match patterns in json array format
     */
    private String urlMatchPatterns;

    /**
     * Max crawler times of a single url ,over it the url will been seen as a bad url
     */
    private Integer urlMaxCrawlCount;

    /**
     * The max depth limitation
     */
    private Integer urlMaxDepth;

    /**
     * The expected total url count
     */
    private Integer bloomExpectedUrlSize;

    /**
     * The hash adjust factor of bloom
     */
    private Double bloomFpp;

    /**
     * The count of url to crawl per task
     */
    private Integer taskUrlBatchCount;

    /**
     * Max task count wait to run (bind success and not running)
     */
    private Integer taskMaxCount;

    /**
     * Current bind count
     */
    private Integer taskCurrentCount;

    /**
     * Max task count can run contaneously
     */
    private Integer taskMaxRunningCount;

    /**
     * Current running task count
     */
    private Integer taskCurrentRunningCount;

    /**
     * Task timeout use by task timout termination job
     */
    private Integer taskTimeout;

    /**
     * Max fail count of a task
     */
    private Integer taskUrlMaxFailCount;

    /**
     * Max continuously fail count of a task
     */
    private Integer taskUrlMaxContinuouslyFailCount;

    /**
     * Max concurrent executing count of url
     */
    private Integer taskUrlMaxConcurrency;
}
