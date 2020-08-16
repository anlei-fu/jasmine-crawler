package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DownSystemSiteMapper {
    DownSystemSite get(@Param("id") Integer id);

    void increaseNewUrlCount(@Param("id") Integer id, @Param("count") int count);

    void increaseBadUrlCount(@Param("id") Integer id, @Param("count") int count);

    void increaseFinishedUrlCount(@Param("id") Integer id, @Param("count") int count);
}
