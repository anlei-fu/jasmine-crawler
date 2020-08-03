package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.Site;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface SiteMapper {
    Site getById(@Param("id") Integer id);
}
