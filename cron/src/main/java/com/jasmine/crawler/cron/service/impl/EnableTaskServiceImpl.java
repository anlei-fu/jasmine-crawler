package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.EnableTaskMapper;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import com.jasmine.crawler.cron.service.EnableTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnableTaskServiceImpl  implements EnableTaskService {

    @Autowired
    private EnableTaskMapper enableTaskMapper;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Transactional
    @Override
    public void scheduleNextEnable(Integer downSystemSiteId, int delayMinutes) {
        downSystemSiteService.disable(downSystemSiteId);
        enableTaskMapper.scheduleNextEnable(downSystemSiteId,delayMinutes);
    }

    @Override
    public void enable() {
        enableTaskMapper.enable();
    }
}
