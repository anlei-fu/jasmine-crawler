package com.jasmine.crawler.cron.component;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class Beans {

    @Bean
    public RedissonClient configConnection() throws IOException {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        config.setCodec(JsonJacksonCodec.INSTANCE);
        config.useSingleServer()
                .setAddress("redis://192.168.29.138:6379")
                .setPassword(null)
                .setDatabase(0);
        return Redisson.create(config);
    }

    @Bean
    public RestTemplate create() {
        return new RestTemplate();
    }
}
