package com.jasmine.crawler.common.pojo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Heartbeat {

    /**
     * File system host "http://ip:port"
     */
    private String fileHost;

    /**
     * Available site ip of web api interface which the crawler word summit task result
     */
    private List<String> masters;

    /**
     * The site ip which send the heartbeat to the crawler worker
     */
    private String master;

}
