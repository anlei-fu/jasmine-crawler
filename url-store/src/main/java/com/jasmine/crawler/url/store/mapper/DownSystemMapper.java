package com.jasmine.crawler.url.store.mapper;

import org.apache.ibatis.annotations.Param;

public interface DownSystemMapper {
    void increaseNewUrlCount(@Param("id") Integer id, @Param("count") int count);

    void increaseFinishedUrlCount(@Param("id") Integer id, @Param("count") int count);

    void increaseBadUrlCount(@Param("id") Integer id, @Param("count") int count);
}
