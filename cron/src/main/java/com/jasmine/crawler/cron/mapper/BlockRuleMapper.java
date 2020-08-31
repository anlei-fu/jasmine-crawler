package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.BlockRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlockRuleMapper {
    List<BlockRule> getByDownSystemSiteId(@Param("downSystemSiteId") Integer downSystemSiteId);
}
