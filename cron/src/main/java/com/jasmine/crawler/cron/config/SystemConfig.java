package com.jasmine.crawler.cron.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
public class SystemConfig {

    /**
     *
     */
    private String crawlerStartNewTaskPath = "/run";

    /**
     *
     */
    private String crawlerHeartbeatPath = "/heartbeat";

    /**
     *
     */
    private List<String> masters;

    /**
     *
     */
    private String fileHost = "http://localhost:80";
}
