package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.DownSystemService;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class UrlCacheTimeoutJob extends LoggerSupport {

    @Autowired
    private UrlService urlService;

    @Autowired
    private DownSystemService downSystemService;

    @Scheduled(cron = "32 */10 * * * *")
    public void run() {

        List<DownSystemSite> downSystemSites = null;
        try {
            downSystemSites = downSystemService.getUrlCacheTimeoutJobSites();
        } catch (Exception ex) {

        }

        info(String.format("got %d site to execute url cache timeout job", downSystemSites.size()));
        if (downSystemSites.size() == 0) {
            info("no sites to execute");
            return;
        }

        int succeed = 0;
        int exception = 0;
        for (final DownSystemSite downSystemSite : downSystemSites) {
            try {
                int t = urlService.resetUrlStatusToWaitByDownSystemSite(downSystemSite);
                info(String.format("downSystemSite(%d) reset %d url state to wait ", downSystemSite.getId(), t));
                succeed++;
                downSystemService.updateUrlLastCacheTimeoutJobTime(downSystemSite.getId());
            } catch (Exception ex) {
                error(String.format("downSystemSite(%d) reset url state to wait failed", downSystemSite.getId()), ex);
                exception++;
            }
        }
        info(String.format("finish url cache timeout job [succeed:%d] [exception:%d]", succeed, exception));

    }
}
