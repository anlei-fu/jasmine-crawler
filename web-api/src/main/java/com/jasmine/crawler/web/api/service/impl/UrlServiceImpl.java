package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.web.api.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void saveUrlResult(SaveUrlResultReq saveUrlResultReq) {
        try {
            R resp = restTemplate.postForObject("", saveUrlResultReq, R.class);
        } catch (Exception ex) {

        }
    }
}
