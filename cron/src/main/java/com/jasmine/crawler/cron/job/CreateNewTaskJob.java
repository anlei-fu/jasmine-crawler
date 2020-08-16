package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateNewTaskJob extends LoggerSupport {

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private CrawlTaskService crawlTaskService;

    /**
     * Create new crawl task , iterate the down site pick the site which current task bind count
     * less than task max bind count
     */
     @Scheduled(cron = "*/10 * * * * *")
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
                if (createTaskCore(downSystemSite)) {
                    succeed++;
                } else {
                    failed++;
                }
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

    @Transactional
    public boolean createTaskCore(DownSystemSite downSystemSite) {
        CrawlTask taskToCreate = CrawlTask.builder()
                .downSystemSiteId(downSystemSite.getId())
                .siteId(downSystemSite.getSiteId())
                .downSystemId(downSystemSite.getDownSystemId())
                .build();
        boolean result = crawlTaskService.add(taskToCreate);
        info(String.format(
                "create task result:%s,down system site id(%d)",
                result,
                downSystemSite.getId()
                )
        );

        if (result) {
            downSystemSiteService.increaseCurrentTaskCount(downSystemSite.getId());
            return true;
        } else {
            return false;
        }
    }
}
