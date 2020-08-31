package com.jasmine.crawler.web.admin.mapper;

import com.jasmine.crawler.common.pojo.entity.Enum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnumMapper {
    List<Enum> getAll();
}
