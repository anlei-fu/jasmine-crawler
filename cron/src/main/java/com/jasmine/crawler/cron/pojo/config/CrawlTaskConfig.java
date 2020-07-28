package com.jasmine.crawler.cron.pojo.config;

import com.jasmine.crawl.common.pojo.entity.Proxy;
import com.jasmine.crawl.common.pojo.entity.SiteUrlCheckRule;
import lombok.Data;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class CrawlTaskConfig {

    private  Integer crawlType;

    private  Integer autoDownloadPage;

    private  String encoding;

    private  Integer timeout;

    private Integer taskId;

    private Integer downSystemSiteId;

    private  Integer siteId;

    private  Integer ProxyId;

    private Proxy proxy;

    private Integer cookieId;

    private String cookie;

    private List<SiteUrlCheckRule> rules;

    private  Integer maxConcurrency;

    private  Integer taskTimeout;

    // json string array
    private  String urlMatchPatterns;

    // json string array
    private  String urlEncodes;

    private  Integer crawlerId;

}
