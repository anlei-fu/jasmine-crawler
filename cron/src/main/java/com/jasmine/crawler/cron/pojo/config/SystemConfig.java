package com.jasmine.crawler.cron.pojo.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
public class SystemConfig {
    private String crawlerStartNewTaskPath;

    private String crawlerHeartbeatPath;

    private int heartbeatSpeedLimit;

    private List<String> masters;

    private String fileHost;
}
