package com.jasmine.crawler.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemMapper {
    void resetConcurrency(@Param("id") Integer id);

    List<Integer> getAllDownSystemSiteId(@Param("id") Integer id);

    void reduceConcurrency(@Param("id") Integer id, @Param("taskCurrentRunningCount") Integer taskCurrentRunningCount);
}
