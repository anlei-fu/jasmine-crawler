package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class UrlCacheTimeoutJob extends LoggerSupport {

    @Autowired
    private UrlService urlService;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    /**
     * Reset cache timeout urls to wait
     */
    @Scheduled(cron = "32 0/10 * * * ?")
    public void run() {

        List<DownSystemSite> downSystemSites = null;
        try {
            downSystemSites = downSystemSiteService.getNeedExecuteUrlCacheTimeoutJobSites();
        } catch (Exception ex) {
            this.error("call getNeedExecuteUrlCacheTimeoutJobSites failed", ex);
        }

        info(String.format("got %d sites to execute url cache timeout reset job", downSystemSites.size()));
        if (downSystemSites.size() == 0) {
            info("no sites to execute");
            return;
        }

        int succeed = 0;
        int exception = 0;
        for (final DownSystemSite downSystemSite : downSystemSites) {
            try {
                int t = urlService.resetCachedUrlToWaitByDownSystemSite(downSystemSite);
                info(String.format("downSystemSite(%d) reset %d urls status to wait ", downSystemSite.getId(), t));
                succeed++;
                downSystemSiteService.updateUrlNextCacheTimeoutJobExecuteTime(downSystemSite.getId());
            } catch (Exception ex) {
                error(String.format("downSystemSite(%d) reset urls status to wait failed", downSystemSite.getId()), ex);
                exception++;
            }
        }
        info(String.format("finish url cache timeout reset job [succeed:%d][exception:%d]", succeed, exception));

    }
}
