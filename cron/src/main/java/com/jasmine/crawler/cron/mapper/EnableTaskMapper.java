package com.jasmine.crawler.cron.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EnableTaskMapper {
    void scheduleNextEnable(@Param("downSystemSiteId") Integer downSystemSiteId, @Param("delayMinutes") int delayMinutes);

    void enable();
}
