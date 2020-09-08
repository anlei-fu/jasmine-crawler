package com.jasmine.crawler.web.api.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.web.api.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlController extends ControllerBase {

    @Autowired
    private UrlService urlService;

    @PutMapping(path = "/url/resetUrls")
    public R<Integer> resetUrls(@RequestBody List<Integer> ids) {
        Integer result = urlService.resetUrls(ids);
        return responseData(result);
    }

    @PutMapping(path = "/url/resetSeedUrl/{downSystemSiteId}")
    public R<Integer> resetSeedUrl(@PathVariable Integer downSystemSiteId) {
        Integer result = urlService.resetSeedUrl(downSystemSiteId);
        return responseData(result);
    }

}
