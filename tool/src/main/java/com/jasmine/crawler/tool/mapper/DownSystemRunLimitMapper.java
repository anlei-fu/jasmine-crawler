package com.jasmine.crawler.tool.mapper;

import com.jasmine.crawler.tool.model.LimitStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemRunLimitMapper {
    void reset(@Param("downSystemSiteId") Integer downSystemId);

    List<LimitStatistics> statistics();

    void enable(@Param("downSystemSiteId") Integer downSystemId, @Param("weekDayType") Integer weekDayType, @Param("hour") Integer hour);
}
