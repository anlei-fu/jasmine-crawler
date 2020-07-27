package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.constant.BindStatus;
import com.jasmine.crawler.cron.constant.BooleanFlag;
import com.jasmine.crawler.cron.constant.DispatchStatus;
import com.jasmine.crawler.cron.pojo.entity.*;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class BindTaskJob extends LoggerSupport {

    @Autowired
    private SiteService siteService;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private BindRecordService bindRecordService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private DownSystemService downSystemService;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Scheduled(cron = "*/6 * * * * ?")
    public void run() {

    }

    private void bindTask(Integer level) {
        info(String.format("-----------begin bind '%d' level task--------------", level));
        List<CrawlTask> tasks = null;
        try {
            tasks = crawlTaskService.getTaskToBind(level);
        } catch (Exception ex) {
            error("call getTaskToBind failed", ex);
            return;
        }

        info(String.format("got %d task to bind", tasks.size()));

        if (tasks.size() == 0) {
            info("no task need to bind");
            return;
        }

        int succeed = 0;
        int failed = 0;
        int exception = 0;
        for (final CrawlTask task : tasks) {
            try {
                boolean bindResult = bindTaskCore(task);
                if (bindResult) {
                    succeed++;
                } else {
                    failed++;
                }
            } catch (Exception ex) {
                error(String.format("bind task(%d) failed", task.getId()), ex);
                exception++;
            }
        }

        info(String.format(
                "finish bind '%d' level task, [succeed:%d][failed:%d][exception:%d]",
                level,
                succeed,
                failed,
                exception)
        );
    }

    /**
     * Bind task, whatever bind result increase bind count
     * 1. check site exist, update site concurrency, task count,
     * 2. check down system exist, update site concurrency, task count,
     * 3. check down system site exist,update site concurrency, task count,
     * 4. find crawler for site, and update crawler current concurrency
     * 5. find cookie for site if need, and update cookie use count
     * 6. find proxy for site if need,and update proxy use count
     */
    private boolean bindTaskCore(CrawlTask taskToBind) {
        boolean isInvalid = false;
        CrawlTask crawlTaskToUpdate = new CrawlTask();
        crawlTaskToUpdate.setBindCount(taskToBind.getBindCount() + 1);
        crawlTaskToUpdate.setLastBindTime(new Date());

        // check site
        Site site = siteService.getById(taskToBind.getSiteId());
        isInvalid = checkIsComponentInvalid(
                site,
                taskToBind.getId(),
                BindStatus.SITE_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "cookie"
        );

        // site has been removed
        if (isInvalid) {
            crawlTaskService.deleteById(taskToBind.getId());
            return false;
        }

        // check down system site
        DownSystemSite downSystemSite = downSystemSiteService.getById(taskToBind.getDownSiteId());
        isInvalid = checkIsComponentInvalid(
                downSystemSite,
                taskToBind.getId(),
                BindStatus.DOWN_SITE_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "downSystemSite"
        );

        if (isInvalid) {

            // down system site has been removed
            if (Objects.isNull(downSystemSite))
                crawlTaskService.deleteById(taskToBind.getId());

            return false;
        }

        // check down system
        DownSystem downSystem = downSystemService.getById(downSystemSite.getDownSystemId());
        isInvalid = checkIsComponentInvalid(
                downSystem,
                taskToBind.getId(),
                BindStatus.DOWN_SYSTEM_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "downSystem"
        );

        if (isInvalid) {

            // down system has been removed
            if (Objects.isNull(downSystem))
                crawlTaskService.deleteById(taskToBind.getId());

            return false;
        }

        // find and check cookie
        if (site.getNeedUseCookie() == BooleanFlag.TRUE) {
            Cookie cookie = cookieService.getBySiteId(site.getId());
            isInvalid = checkIsComponentInvalid(
                    cookie,
                    taskToBind.getId(),
                    BindStatus.NO_COOKIE_AVAILABLE,
                    crawlTaskToUpdate,
                    "cookie"
            );

            if (isInvalid)
                return false;

            taskToBind.setCookieId(cookie.getId());
        }

        // find and check proxy
        if (site.getNeedUseProxy() == BooleanFlag.TRUE) {
            Proxy proxy = proxyService.getProxyBySiteId(site.getId());
            isInvalid = checkIsComponentInvalid(
                    proxy,
                    taskToBind.getId(),
                    BindStatus.NO_PROXY_AVAILABLE,
                    crawlTaskToUpdate,
                    "proxy"
            );

            if (isInvalid)
                return false;

            crawlTaskToUpdate.setProxyId(proxy.getId());
        }

        // find crawler and check crawler
        Crawler crawler = crawlerService.getCrawlerBySite(site.getId());
        isInvalid = checkIsComponentInvalid(
                crawler,
                taskToBind.getId(),
                BindStatus.NO_PROXY_AVAILABLE,
                crawlTaskToUpdate,
                "crawler"
        );

        if (isInvalid)
            return false;

        crawlTaskToUpdate.setCrawlerId(crawler.getId());

        bindSuccess(taskToBind.getId(),crawlTaskToUpdate,site,downSystemSite,crawler);
        info(String.format("bind task(%d) succeed",taskToBind.getId()));
        return true;
    }

    private boolean checkIsComponentInvalid(
            Object target,
            Integer taskToBindId,
            Integer bindStatus,
            CrawlTask taskToUpdate,
            String msg) {
        if (Objects.isNull(target)
                || ((target instanceof EnableStatusFeature)
                && ((EnableStatusFeature) target).getEnableStatus() == BooleanFlag.FALSE)
        ) {
            taskToUpdate.setBindStatus(bindStatus);
            crawlTaskService.updateById(taskToUpdate.getId(), taskToUpdate);
            bindRecordService.add(taskToUpdate.getId(), taskToUpdate.getBindStatus(),msg);
            info(String.format(
                    "bind task(%d) failed,cause %s",
                    taskToBindId,
                    msg
            ));
            return true;
        }

        return false;
    }


    private void bindSuccess(Integer taskToBindId,CrawlTask crawlTaskToUpdate,Site site,DownSystemSite downSystemSite,Crawler crawler){

        siteService.increaseTaskRunningCountById(site.getId());
        downSystemSiteService.increaseTaskRunningCountById(downSystemSite.getDownSystemId());
        downSystemService.increaseTaskRunningCountById(downSystemSite.getId());

        if (site.getNeedUseCookie() == BooleanFlag.TRUE)
            cookieService.increaseCurrentUseCountById(crawlTaskToUpdate.getId());

        if (site.getNeedUseProxy() == BooleanFlag.TRUE)
            proxyService.increaseCurrentUseCountById(crawlTaskToUpdate.getId());

        // update crawler current concurrency
        crawlerService.updateConcurrencyById(
                crawler.getId(),
                crawler.getCurrentConcurrency() + site.getCurrentConcurrency()
        );

        // update task bind status
        crawlTaskToUpdate.setBindStatus(BindStatus.SUCCESS);
        crawlTaskToUpdate.setDispatchStatus(DispatchStatus.WAIT);
        boolean result = crawlTaskService.updateById(taskToBindId, crawlTaskToUpdate);
    }
}
