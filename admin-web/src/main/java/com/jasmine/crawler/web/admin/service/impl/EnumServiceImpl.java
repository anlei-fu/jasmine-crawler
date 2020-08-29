package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.Enum;
import com.jasmine.crawler.web.admin.mapper.EnumMapper;
import com.jasmine.crawler.web.admin.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnumServiceImpl implements EnumService {

    @Autowired
    private EnumMapper enumMapper;

    @Override
    public List<Enum> getAll() {
        return enumMapper.getAll();
    }
}
