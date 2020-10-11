package com.jasmine.crawler.cron.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Data
@Configuration
public class SystemConfig {

    public SystemConfig() {
        this.masters = new LinkedList<>();
        this.masters.add("http://192.168.29.1:10032");
    }

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
    private String fileHost = "http://192.168.29.138:80";
}
