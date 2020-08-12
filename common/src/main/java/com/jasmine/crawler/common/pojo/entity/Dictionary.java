package com.jasmine.crawler.common.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class Dictionary {
    private Integer id;

    private String type;

    private Integer value;

    private String label;

    private String color;

    private Date createTime;
}
