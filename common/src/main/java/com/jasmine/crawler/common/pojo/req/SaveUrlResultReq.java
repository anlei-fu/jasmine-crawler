package com.jasmine.crawler.common.pojo.req;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveUrlResultReq {

    /**
     * Page results
     */
    private List<PageResult> pageResults;

    /**
     * Task id
     */
    private Integer taskId;

    /**
     * Down system site id
     */
    private Integer downSystemSiteId;
}
