package com.jasmine.crawler.tool.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownSystemSiteMapper {
    void resetConcurrency(@Param("id") Integer id);

    DownSystemSite getConcurrency(@Param("id") Integer id);

    DownSystemSite get(@Param("id") Integer id);
}
