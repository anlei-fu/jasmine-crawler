package com.jasmine.crawler.cron.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface SiteAccountMapper {

    void disableAccounts();

    void increaseCurrentUseCount(@Param("id") Integer id);

    void decreaseCurrentUseCount(@Param("id") Integer id);

    void updateDelayTimeout(@Param("id") Integer id);
}
