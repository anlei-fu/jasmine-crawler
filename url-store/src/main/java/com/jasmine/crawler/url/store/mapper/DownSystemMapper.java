package com.jasmine.crawler.url.store.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DownSystemMapper {
    void increaseNewUrlCount(@Param("id") Integer id, @Param("count") int count);

    void increaseFinishedUrlCount(@Param("id") Integer id, @Param("count") int count);

    void increaseBadUrlCount(@Param("id") Integer id, @Param("count") int count);
}