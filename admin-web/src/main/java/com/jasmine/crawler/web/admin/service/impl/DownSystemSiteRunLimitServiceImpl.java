package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import com.jasmine.crawler.web.admin.mapper.DownSystemSiteRunLimitMapper;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemRunLimitReq;
import com.jasmine.crawler.web.admin.service.DownSystemSiteRunLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownSystemSiteRunLimitServiceImpl implements DownSystemSiteRunLimitService {

    @Autowired
    private DownSystemSiteRunLimitMapper downSystemSiteRunLimitMapper;

    @Override
    public List<DownSystemSiteRunLimit> getByDownSystemSiteId(Integer downSystemSiteId) {
        return downSystemSiteRunLimitMapper.getByDownSystemSiteId(downSystemSiteId);
    }

    @Override
    public boolean disable(Integer id) {
        return downSystemSiteRunLimitMapper.disable(id) > 0;
    }

    @Override
    public boolean enable(Integer id) {
        return downSystemSiteRunLimitMapper.enable(id) > 0;
    }

    @Override
    public void createLimit(int id) {
        for (int t= 0;t<7;t++){
            for (int k=0;k<24;k++){
                DownSystemSiteRunLimit limit  = DownSystemSiteRunLimit.builder()
                        .downSystemSiteId(id)
                        .weekDayType(t)
                        .hour(k)
                        .build();
                downSystemSiteRunLimitMapper.add(limit);
            }
        }
    }

    @Override
    public boolean update(UpdateDownSystemRunLimitReq req) {
        downSystemSiteRunLimitMapper.updateDisable(req);
        downSystemSiteRunLimitMapper.updateEnable(req);

       return  true;
    }
}
