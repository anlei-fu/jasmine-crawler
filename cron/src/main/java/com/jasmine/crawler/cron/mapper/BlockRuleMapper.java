package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.BlockRule;
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
public interface BlockRuleMapper {
    List<BlockRule> getByDownSystemSiteId(@Param("downSystemSiteId") Integer downSystemSiteId);
}
