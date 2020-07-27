package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.cron.pojo.entity.DownSystem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface DownSystemMapper {
    DownSystem getById(Integer downSystemId);

    void increaseTaskRunningCountById(Integer id);

    void decreaseCurrentRunningTaskCountById(Integer id);
}
