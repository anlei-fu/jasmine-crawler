package com.jasmine.crawler.web.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface DownSystemMapper {
    void decreaseCurrentRunningTaskCount(@Param("id") Integer id);
}
