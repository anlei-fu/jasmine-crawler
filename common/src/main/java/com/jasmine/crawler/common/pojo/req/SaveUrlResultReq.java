package com.jasmine.crawler.common.pojo.req;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveUrlResultReq {
    private List<PageResult> pageResults;

    private Integer taskId;

    private Integer downSystemSiteId;
}
