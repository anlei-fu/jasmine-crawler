package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownSystemMapper {
    DownSystem getById(@Param("id") Integer id);

    void increaseTaskRunningCountById(@Param("id") Integer id);

    void decreaseCurrentRunningTaskCountById(@Param("id") Integer id);
}
