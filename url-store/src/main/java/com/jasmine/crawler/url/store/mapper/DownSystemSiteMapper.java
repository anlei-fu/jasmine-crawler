package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownSystemSiteMapper {
    DownSystemSite get(@Param("id") Integer id);

    void addNewUrlCount(@Param("id") Integer id, @Param("count") int count);

    void addBadUrlCount(@Param("id") Integer id, @Param("count") int count);

    void addFinishedUrlCount(@Param("id") Integer id, @Param("count") int count);
}
