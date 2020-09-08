package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownSystemSiteMapper {
    void decreaseCurrentRunningTaskCount(@Param("id") Integer id);

    DownSystemSite get(@Param("id") Integer downSystemSiteId);

}

