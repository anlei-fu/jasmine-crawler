package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class CrawlTaskTerminator {

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private DownSystemService downSystemService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private SiteAccountService siteAccountService;

    public void terminate(CrawlTask task) {

        DownSystemSite downSystemSite = downSystemSiteService.get(task.getDownSystemSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCount(downSystemSite.getId());
        }

        downSystemService.decreaseCurrentRunningTaskCount(downSystemSite.getDownSystemId());

        if (task.getProxyId() != BooleanFlag.NO_NEED)
            proxyService.decreaseCurrentUseCount(task.getProxyId());

        if (task.getCookieId() != BooleanFlag.NO_NEED) {
            cookieService.decreaseCurrentUseCount(task.getCookieId());
            Cookie cookie = cookieService.get(task.getCookieId());
            siteAccountService.decreaseCurrentUseCount(cookie.getAccountId());
        }

        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler)) {
            crawlerService.changeCurrentConcurrency(
                    crawler.getId(),
                    -downSystemSite.getTaskUrlMaxConcurrency()
            );
        }
    }
}
