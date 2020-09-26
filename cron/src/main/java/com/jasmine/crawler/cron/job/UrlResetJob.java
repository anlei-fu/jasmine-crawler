package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlResetJob extends LoggerSupport {
    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private UrlService urlService;

    public void run() {
        List<DownSystemSite> downSystemSites = null;
        try {
            downSystemSites = downSystemSiteService.getNeedExecuteResetJobSites();
        } catch (Exception ex) {

        }

        info(String.format("got %d site to execute url reset job", downSystemSites.size()));
        if (downSystemSites.size() == 0) {
            info("no sites to execute");
            return;
        }

        int succeed = 0;
        int exception = 0;
        for (final DownSystemSite downSystemSite : downSystemSites) {
            try {
                int t = urlService.resetSuccessUrlToWaitByDownSystemSite(downSystemSite);
                info(String.format("downSystemSite(%d) reset %d url state to wait ", downSystemSite.getId(), t));
                succeed++;
                downSystemSiteService.updateUrlNextResetJobExecuteTime(downSystemSite.getId());
            } catch (Exception ex) {
                error(String.format("downSystemSite(%d) reset url state to wait failed", downSystemSite.getId()), ex);
                exception++;
            }
        }
        info(String.format("finish url cache timeout job [succeed:%d] [exception:%d]", succeed, exception));
    }
}
