package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CookieMapper {
    Cookie getById(@Param("id") Integer id);

    void decreaseCurrentUseCount(@Param("id") Integer id);

    void increaseBlockCount(@Param("id") Integer id);

    void resetBlockCount(@Param("id") Integer id);

    void disable(Integer id);
}
