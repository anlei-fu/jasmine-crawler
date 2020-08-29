package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SiteAccountMapper {
    SiteAccount get(@Param("id") Integer id);

    void increaseBlockCount(@Param("id") Integer id);

    void resetBlockCount(@Param("id") Integer id);

    void decreaseCurrentUseCount(@Param("id") Integer id);

    void block(@Param("id") Integer id);
}
