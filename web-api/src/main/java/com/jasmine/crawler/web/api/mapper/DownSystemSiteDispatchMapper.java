package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemSiteDispatchMapper {
    List<DownSystemSiteDispatch> getBySourceDownSystemSiteId(@Param("sourceDownSystemSiteId") Integer sourceDownSystemSiteId);
}
