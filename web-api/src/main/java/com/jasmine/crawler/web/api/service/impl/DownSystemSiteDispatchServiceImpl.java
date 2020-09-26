package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.component.StringMatcher;
import com.jasmine.crawler.common.component.impl.JasmineStringMatcher;
import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.mapper.DownSystemSiteDispatchMapper;
import com.jasmine.crawler.web.api.service.DownSystemSiteDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DownSystemSiteDispatchServiceImpl implements DownSystemSiteDispatchService {

    @Autowired
    private DownSystemSiteDispatchMapper downSystemSiteDispatchMapper;

    @Override
    public Map<Integer, List<Url>> dispatch(SaveTaskResultReq req, Integer downSystemSiteId) {
        List<DownSystemSiteDispatch> dispatches = downSystemSiteDispatchMapper.getBySourceDownSystemSiteId(downSystemSiteId);

        // init all matchers
        Map<Integer, StringMatcher> matchers = new HashMap<>();
        for (DownSystemSiteDispatch dispatch : dispatches) {
            matchers.putIfAbsent(dispatch.getTargetDownSystemSiteId(), new JasmineStringMatcher(dispatch.getPattern()));
        }

        Map<Integer, List<Url>> map = new HashMap<>();
        for (PageResult pageResult : req.getPageResults()) {
            for (Url url : pageResult.getNewUrls()) {
                if (Objects.isNull(url.getUrl()))
                    continue;

                for (Map.Entry<Integer, StringMatcher> matcherEntry : matchers.entrySet()) {
                    try {
                        if (matcherEntry.getValue().match(url.getUrl())) {
                            map.putIfAbsent(matcherEntry.getKey(), new LinkedList<>());
                            List<Url> urls = map.get(matcherEntry.getKey());
                            urls.add(url);
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        }

        return map;
    }
}
