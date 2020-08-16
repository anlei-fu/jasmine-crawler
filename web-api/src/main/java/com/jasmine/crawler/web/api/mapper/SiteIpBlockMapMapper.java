package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface SiteIpBlockMapMapper {
    void add(SiteIpBlockMap siteIpBlockMap);
}
