package com.jasmine.crawler.cron.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface TaskSnapShot10MinuteMapper {
    void snapShot10Minute(@Param("time") Date time);

    void delete(@Param("time") Date time);
}
