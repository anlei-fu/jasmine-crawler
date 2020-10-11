package com.jasmine.crawler.web.admin.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.web.admin.pojo.vo.DownSystemSiteDispatchDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DownSystemSiteDispatchMapper {
    List<DownSystemSiteDispatchDetail> getBySourceDownSystemSiteId(@Param("sourceDownSystemSiteId") Integer sourceDownSystemSiteId);

    int add(DownSystemSiteDispatch req);

    int delete(Integer id);
}
