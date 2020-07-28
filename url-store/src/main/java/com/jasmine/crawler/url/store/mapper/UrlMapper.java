package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.url.store.pojo.entity.Url;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface UrlMapper {
    List<Url> getUrlToCacheByDownSiteId(Integer downSystemSiteId, Integer urlMaxCacheCount);
}
