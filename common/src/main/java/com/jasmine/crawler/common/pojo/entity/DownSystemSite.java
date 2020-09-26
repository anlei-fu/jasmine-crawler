package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

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
     * The type of down system sitews
     */
    private Integer downSystemSiteType;

    /**
     * Name identifier
     */
    private String name;

    /**
     * Description of site
     */
    private String description;

    /**
     * The script to run crawl task
     */
    private String scriptPath;

    /**
     * Priority of the site , use for task binding rank
     */
    private Integer priority;

    /**
     *
     * Crawler setting
     *
     */

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
     * or download page by self in page process script
     */
    private Integer crawlerAutoDownloadPage;


    /**
     * Url setting of site
     */

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
     * Url cache timeout job execute interval,"-1" no need, minute
     */
    private Integer urlCacheTimeoutJobExecuteInterval;

    /**
     * The timeout url since last cache,  minute
     */
    private Integer urlCacheTimeout;

    /**
     * The time that url cache timeout job fire
     */
    private Date urlNextCacheTimeoutJobTime;

    /**
     * Url faield retry job execute interval,"-1" no need , minute
     */
    private Integer urlFailedRetryJobExecuteInterval;

    /**
     * The timout since last url failed ,minute
     */
    private Integer urlFailedRetryTimeout;

    /**
     * The time url failed retry job fire
     */
    private Date urlNextFailedRetryJobExecuteTime;

    /**
     * The interval for url reset job , "-1" no need to execute, minute
     */
    private Integer urlResetJobExecuteInterval;

    /**
     * The time url reset job fire
     */
    private Date urlNextResetJobExecuteTime;

    /**
     * The timeout since last success
     */
    private Integer urlResetTimeout;


    /**
     *
     * Bloom filter setting
     *
     */

    /**
     * The expected total url count
     */
    private Integer bloomExpectedUrlSize;

    /**
     * The hash adjust factor of bloom
     */
    private Double bloomFpp;

    /**
     * The time the bloom last load
     */
    private Date bloomDumpTime;

    /**
     * The status of bloom
     */
    private Integer bloomLoadStatus;


    /**
     *
     *  Task setting
     *
     */

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
     * Task executing timeout , using by task timout termination job
     */
    private Integer taskTimeout;

    /**
     * The biding timeout , using by task biding termination job
     */
    private Integer taskBindTimeout;

    /**
     * Max fail count of url per task
     */
    private Integer taskUrlMaxFailCount;

    /**
     * Max continuously fail count of url per task
     */
    private Integer taskUrlMaxContinuouslyFailCount;

    /**
     * Max concurrent executing count of url
     */
    private Integer taskUrlMaxConcurrency;

    /***
     *
     * Task run limitation
     *
     */

    /**
     * Determine if the site running plan can be balanced by default procedure
     */
    private Integer runLimitAllowAutoBalance;

    /**
     * The day count per week that site can run
     */
    private Integer runLimitMaxDays;

    /**
     * The hour count that site can run of a day
     */
    private Integer runLimitMaxHours;

}
