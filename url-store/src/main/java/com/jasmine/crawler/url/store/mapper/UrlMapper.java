package com.jasmine.crawler.url.store.mapper;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.entity.Url;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UrlMapper {
    List<Url> getUrlToCacheForSite(@Param("downSystemSiteId") Integer downSystemSiteId, @Param("maxCount") Integer urlMaxCacheCount);

    void addBatch(@Param("list") List<Url> newUrls);

    void updateStatus(@Param("list") Url urlToUpdate);

    void failed(@Param("list") Url urlToUpdate);

    void updateUrlStatusToCached(@Param("list") List<Url> urls);

    void failedUrls(@Param("list") List<PageResult> list);

    void badUrls(@Param("list") List<PageResult> list);

    void failToRunUrls(@Param("list") List<PageResult> list);

    void successUrls(@Param("list") List<PageResult> list);
}
