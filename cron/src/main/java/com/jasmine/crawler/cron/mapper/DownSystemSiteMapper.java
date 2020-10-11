package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemSiteMapper {
    List<DownSystemSite> getNeedCreateNewTaskSites();

    DownSystemSite getById(@Param("id") Integer id);

    void increaseCurrentRunningTaskCount(@Param("id") Integer id);

    void decreaseCurrentRunningTaskCount(@Param("id") Integer id);

    void increaseCurrentTaskCount(@Param("id") Integer id);

    void decreaseCurrentTaskCount(@Param("id") Integer id);

    List<DownSystemSite> getNeedExecuteFailedRetryJobSites();

    void updateUrlNextFailedRetryJobTime(@Param("id") Integer id);

    List<DownSystemSite> getNeedExecuteResetJobSites();

    void updateUrlNextResetJobTime(@Param("id") Integer id);

    List<DownSystemSite> getUrlCacheTimeoutJobSites();

    void updateUrlNextCacheTimeoutJobTime(@Param("id") Integer id);
}
