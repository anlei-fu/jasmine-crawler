package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProxyMapper {
    Proxy getById(@Param("id") Integer proxyId);

    void decreaseCurrentUseCount(@Param("id") Integer id);

    void increaseBlockCount(@Param("id") Integer id);

    void resetBlockCount(@Param("id") Integer id);
}
