package com.jasmine.crawler.web.admin.mapper;

import com.jasmine.crawler.common.pojo.entity.Enum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface EnumMapper {
    List<Enum> getAll();
}
