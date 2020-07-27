package com.jasmine.crawler.cron.pojo.req;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
public class Heartbeat {
    private  String fileHost;

    private List<String> masters;

    private  String master;

}
