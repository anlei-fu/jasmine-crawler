package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface BloomMapper {

    SiteUrlBloom get(@Param("id") Integer id);

    void add(SiteUrlBloom siteUrlBloom);

    void dump(SiteUrlBloom siteUrlBloom);
}
