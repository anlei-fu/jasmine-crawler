package com.jasmine.crawler.url.store.mapper;

import org.mapstruct.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface BloomMapper {
    int countById(Integer id);

    int createById(Integer id);

    int disableById(Integer id);
}
