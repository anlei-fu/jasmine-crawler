package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlFailedRetryJob extends LoggerSupport {

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private UrlService urlService;

    @Scheduled(cron = "0 0/13 * * * ?")
    public void run() {
        List<DownSystemSite> downSystemSites = null;
        try {
            downSystemSites = downSystemSiteService.getNeedExecuteFailedRetryJobSites();
        } catch (Exception ex) {
            this.error("call getNeedExecuteFailedRetryJobSites failed", ex);
        }

        info(String.format("got %d site to execute url failed retry job", downSystemSites.size()));
        if (downSystemSites.size() == 0) {
            info("no sites to execute");
            return;
        }

        int succeed = 0;
        int exception = 0;
        for (final DownSystemSite downSystemSite : downSystemSites) {
            try {
                int t = urlService.resetFailedUrlToWaitByDownSystemSite(downSystemSite);
                info(String.format("downSystemSite(%d) reset %d urls status to wait ", downSystemSite.getId(), t));
                succeed++;
                downSystemSiteService.updateUrlNextFailedRetryJobExecuteTime(downSystemSite.getId());
            } catch (Exception ex) {
                error(String.format("downSystemSite(%d) reset urls status to wait failed", downSystemSite.getId()), ex);
                exception++;
            }
        }
        info(String.format("finish url failed retry job [succeed:%d] [exception:%d]", succeed, exception));
    }
}
