package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface DownSystemSiteMapper {
    void decreaseCurrentRunningTaskCount(@Param("id") Integer id);

    DownSystemSite get(Integer downSystemSiteId);
}

