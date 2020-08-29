package com.jasmine.crawler.cron.pojo.req;

import com.jasmine.crawler.common.pojo.entity.BlockRule;
import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.common.pojo.entity.Url;
import lombok.Data;

import java.util.List;

@Data
public class CrawlTaskConfig {

    /**
     * Task id
     */
    private Integer taskId;

    private Integer siteId;

    private Integer downSystemSiteId;

    /**
     * Task urls
     */
    private List<Url> urls;

    /**
     * Block rules
     */
    private List<BlockRule> blockRules;

    // crawler config
    /**
     * Crawler to run the task
     */
    private Integer crawlerId;

    /***
     * The crawl task type see {@enum CrawlType}
     */
    private Integer crawlType;

    private Integer userAgentType;

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
    private Integer downloadPageTimeout;

    /**
     * json string array
     */
    private String urlMatchPatterns;

    /**
     * json string array
     */
    private String urlEncodes;

    // proxy config
    /**
     * The proxy config ,'-1' not use proxy
     */
    private Integer proxyId;

    /**
     * Proxy info see {@Type Poxy}
     */
    private Proxy proxy;

    // script config
    /**
     * Crawl script path
     */
    private String scriptPath;

    // cookie config
    /**
     * The cookie  -1 no need use cookie
     */
    private Integer cookieId;

    /**
     * cookie in json string
     */
    private String cookie;

    /**
     * Task max concurrency
     */
    private Integer ipMinuteSpeedLimit;

    /**
     *
     */
    private Integer urlMaxFailCount;

    /**
     *
     */
    private Integer urlMaxContinuouslyFailCount;

    /**
     *
     */
    private Integer urlMaxConcurrency;

    /**
     *
     */
    public String headers;

    /**
     *
     */
    public String additionalParams;

}
