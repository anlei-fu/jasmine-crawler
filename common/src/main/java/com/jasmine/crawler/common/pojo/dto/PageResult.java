package com.jasmine.crawler.common.pojo.dto;

import com.jasmine.crawler.common.pojo.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    private Integer id;

    private Integer taskId;

    private String data;

    private String msg;

    private Integer httpStatus;

    private Integer pageResult;

    private Date crawlTime;

    private List<Url> newUrls;
}
