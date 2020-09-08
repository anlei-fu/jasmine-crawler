package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystem;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemMapper {
    DownSystem getById(@Param("id") Integer id);

    void increaseTaskRunningCountById(@Param("id") Integer id);

    void decreaseCurrentRunningTaskCountById(@Param("id") Integer id);

    List<DownSystemSite> getUrlCacheTimeoutJobSites();

    void updateUrlLastCacheTimeoutJobTime(@Param("id") Integer id);
}
