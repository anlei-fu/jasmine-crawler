package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Enum;
import com.jasmine.crawler.web.admin.service.EnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@RestController
public class EnumController extends ControllerBase {

    @Autowired
    private EnumService enumService;

    @GetMapping(path = "/enum/all")
    public R<List<Enum>> getAll() {
        List<Enum> result = enumService.getAll();
        return responseData(result);
    }
}
