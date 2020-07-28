package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawl.common.pojo.entity.DownSystemSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface DownSystemSiteMapper {
    List<DownSystemSite> getNeedCreateNewTaskSite();

    DownSystemSite getById(@Param("id") Integer id);

    void increaseTaskRunningCountById(@Param("id") Integer id);
}
