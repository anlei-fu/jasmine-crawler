package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.url.store.pojo.entity.Site;
import org.mapstruct.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface SiteMapper {
    Site getById(Integer siteId);
}
