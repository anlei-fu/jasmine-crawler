package com.jasmine.crawler.web.admin.mapper;

import com.jasmine.crawler.common.pojo.entity.BlockRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface BlockRuleMapper {
    int add(BlockRule blockRule);

    int delete(Integer id);

    int deleteBatch(List<Integer> ids);

    List<BlockRule> getByDownSystemSiteId(Integer downSystemSiteId);
}
