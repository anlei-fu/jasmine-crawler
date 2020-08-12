package com.jasmine.crawler.cron.component;

import com.jasmine.crawler.common.support.Counter;
import org.redisson.api.RedissonClient;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class RedisCounter implements Counter {

    private RedissonClient client;

    private int max;

    private int expire;

    private String id;

    private Date lastActive;

    public RedisCounter(RedissonClient client, String id, int max, int expire) {
        this.client = client;
        this.max = max;
        this.expire = expire;
    }

    @Override
    public void increase(int value) {

    }

    @Override
    public boolean overMax() {
        return false;
    }

    public Date getLastActive() {
        return this.lastActive;
    }
}
