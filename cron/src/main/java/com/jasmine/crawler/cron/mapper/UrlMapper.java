package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UrlMapper {
    int resetCachedUlrToWaitByDownSystemSite(DownSystemSite downSystemSiteId);

    int resetFailedUrlToWaitByDownSystemSite(DownSystemSite downSystemSite);

    int resetSucceedUrlToWaitByDownSystemSite(DownSystemSite downSystemSite);
}
