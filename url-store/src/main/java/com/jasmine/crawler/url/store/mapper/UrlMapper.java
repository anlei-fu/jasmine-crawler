package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.common.pojo.entity.Url;
import org.apache.ibatis.annotations.Param;
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
    List<Url> getUrlToCacheForSite(@Param("downSystemSiteId") Integer downSystemSiteId, @Param("maxCount") Integer urlMaxCacheCount);

    void addBatch(@Param("list") List<Url> newUrls);

    void updateStatus(@Param("list") Url urlToUpdate);

    void failed(@Param("list") Url urlToUpdate);

    void updateUrlStatusToWait(@Param("list") List<Url> urls);

    void failUrls(@Param("list") List<String> list, @Param("downSystemSiteId") Integer downSystemSiteId);

    void badUrls(@Param("list") List<String> list, @Param("downSystemSiteId") Integer downSystemSiteId);

    void failToRunUrls(@Param("list") List<String> list, @Param("downSystemSiteId") Integer downSystemSiteId);

    void successUrls(@Param("list") List<String> list, @Param("downSystemSiteId") Integer downSystemSiteId);
}
