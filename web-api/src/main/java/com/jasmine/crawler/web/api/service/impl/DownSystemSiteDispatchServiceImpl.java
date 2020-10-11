package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.component.StringMatcher;
import com.jasmine.crawler.common.component.impl.JasmineStringMatcher;
import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.mapper.DownSystemSiteDispatchMapper;
import com.jasmine.crawler.web.api.model.Matcher;
import com.jasmine.crawler.web.api.service.DownSystemSiteDispatchService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class DownSystemSiteDispatchServiceImpl implements DownSystemSiteDispatchService {

    @Autowired
    private DownSystemSiteDispatchMapper downSystemSiteDispatchMapper;

    @Override
    public Map<Integer, List<Url>> dispatch(SaveTaskResultReq req, Integer downSystemSiteId) {
        List<DownSystemSiteDispatch> dispatches = downSystemSiteDispatchMapper.getBySourceDownSystemSiteId(downSystemSiteId);
        List<Matcher> matchers = new LinkedList<>();
        for (final DownSystemSiteDispatch dispatch : dispatches) {
            Matcher matcher = Matcher.builder()
                    .pattern(Pattern.compile(dispatch.getMatchPattern()))
                    .downSystemSiteId(dispatch.getTargetDownSystemSiteId())
                    .build();
            matchers.add(matcher);
        }

        Map<Integer, List<Url>> map = new HashMap<>();
        for (PageResult pageResult : req.getPageResults()) {
            for (Url url : pageResult.getNewUrls()) {
                if (Objects.isNull(url.getUrl()))
                    continue;

                for (Matcher matcher : matchers) {
                    try {
                        if (matcher.getPattern().matcher(url.getUrl()).matches()) {
                            map.putIfAbsent(matcher.getDownSystemSiteId(), new LinkedList<>());
                            List<Url> urls = map.get(matcher.getDownSystemSiteId());
                            urls.add(url);
                            break;
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        }

        return map;
    }


}
