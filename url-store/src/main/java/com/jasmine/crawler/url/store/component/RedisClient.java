package com.jasmine.crawler.url.store.component;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RedisClient {

    @Bean
    public RedissonClient configConnection() throws IOException {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        config.setCodec(JsonJacksonCodec.INSTANCE);
        config.useSingleServer()
                .setAddress("redis://192.168.117.152:6379")
                .setPassword(null)
                .setDatabase(0);
        return Redisson.create(config);
    }
}
