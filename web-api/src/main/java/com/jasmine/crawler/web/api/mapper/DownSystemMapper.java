package com.jasmine.crawler.web.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownSystemMapper {
    void decreaseCurrentRunningTaskCount(@Param("id") Integer id);


}
