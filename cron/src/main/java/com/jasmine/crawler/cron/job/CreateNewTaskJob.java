package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateNewTaskJob extends LoggerSupport {

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private CrawlTaskService crawlTaskService;

    /**
     * Create new crawl task
     */
    @Scheduled(cron = "* 0/2 * * * *")
    public void run() {
        info("-----------begin creating task--------------");
        List<DownSystemSite> downSystemSites = null;
        try {
            downSystemSites = downSystemSiteService.getNeedCreateNewTaskSites();
        } catch (RuntimeException ex) {
            error(String.format("run getNeedCreateNewTaskSite sql failed"), ex);
            return;
        }

        info(String.format("get %d site to create", downSystemSites.size()));

        if (downSystemSites.size() == 0) {
            info("no down system site need to create task");
            return;
        }

        int succeed = 0;
        int failed = 0;
        int exception = 0;
        for (final DownSystemSite downSystemSite : downSystemSites) {
            try {
                CrawlTask taskToCreate = CrawlTask.builder()
                        .siteId(downSystemSite.getSiteId())
                        .downSystemSiteId(downSystemSite.getId())
                        .build();
                boolean result = crawlTaskService.add(taskToCreate);
                if (result) {
                    succeed++;
                } else {
                    failed++;
                }

                info(String.format(
                        "create task result:%s,down system site id(%d)",
                        result,
                        downSystemSite.getId()
                        )
                );
            } catch (Exception ex) {
                error(String.format("create task failed, and site is %d", downSystemSite.getId()), ex);
                exception++;
            }

            info(String.format(
                    "finish create task succeed:%d,failed:%d,exception:%d",
                    succeed,
                    failed,
                    exception)
            );
        }
    }
}
