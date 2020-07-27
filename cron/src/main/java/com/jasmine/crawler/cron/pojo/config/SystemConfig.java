package com.jasmine.crawler.cron.pojo.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Configuration
public class SystemConfig {
    private  String crawlerStartNewTaskPath;

    private  String crawlerHeartbeatPath;

    private  int heartbeatSpeedLimit;

    private List<String> masters;


    private  String fileHost;
}
