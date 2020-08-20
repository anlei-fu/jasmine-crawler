package com.jasmine.crawler.web.admin.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemSiteRunLimitMapper {
    List<DownSystemSiteRunLimit> getByDownSystemSiteId(@Param("downSystemSiteId") Integer downSystemSiteId);

    int disable(@Param("id") Integer id);

    int enable(@Param("id") Integer id);
}
