package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemSiteMapper {
    List<DownSystemSite> getNeedCreateNewTaskSite();

    DownSystemSite getById(@Param("id") Integer id);

    void increaseRunningTaskCountById(@Param("id") Integer id);

    void decreaseCurrentRunningTaskCountById(@Param("id") Integer id);
}
