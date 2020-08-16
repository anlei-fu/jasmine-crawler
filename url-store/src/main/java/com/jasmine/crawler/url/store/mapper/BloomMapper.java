package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BloomMapper {

    SiteUrlBloom get(@Param("id") Integer id);

    void dump(SiteUrlBloom siteUrlBloom);
}
