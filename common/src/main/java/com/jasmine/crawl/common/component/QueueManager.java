package com.jasmine.crawl.common.component;

import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface QueueManager {
  ConcurrentLinkedQueue getById(String id);
}
