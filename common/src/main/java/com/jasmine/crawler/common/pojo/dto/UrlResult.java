package com.jasmine.crawler.common.pojo.dto;

import com.jasmine.crawler.common.pojo.entity.Url;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UrlResult {
    private Integer id;

    private String data;

    private String msg;

    private Integer httpStatus;

    private Integer pageResult;

    private Date crawlTime;

    private List<Url> newUrls;
}
