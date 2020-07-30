package com.jasmine.crawler.common.pojo.entity;

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

    /**
     * File system host "ip:port"
     */
    private String fileHost;

    /**
     * Available masters ip
     */
    private List<String> masters;

    /**
     * The master which send the heartbeat
     */
    private String master;

}
