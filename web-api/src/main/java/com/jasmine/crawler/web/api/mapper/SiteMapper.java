package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.Site;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SiteMapper {
    Site getById(@Param("id") Integer id);
}
