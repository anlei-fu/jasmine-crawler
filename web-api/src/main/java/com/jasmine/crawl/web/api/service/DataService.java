package com.jasmine.crawl.web.api.service;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DataService {
    boolean saveData(String key, List<String> data);
}
