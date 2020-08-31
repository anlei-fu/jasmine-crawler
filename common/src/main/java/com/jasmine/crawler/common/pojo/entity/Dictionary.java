package com.jasmine.crawler.common.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Dictionary {
    private Integer id;

    private String type;

    private Integer value;

    private String label;

    private String color;

    private Date createTime;
}
