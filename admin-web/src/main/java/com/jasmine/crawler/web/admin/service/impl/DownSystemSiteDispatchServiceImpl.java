package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.web.admin.mapper.DownSystemSiteDispatchMapper;
import com.jasmine.crawler.web.admin.pojo.vo.DownSystemSiteDispatchDetail;
import com.jasmine.crawler.web.admin.service.DownSystemSiteDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownSystemSiteDispatchServiceImpl implements DownSystemSiteDispatchService {

    @Autowired
    private DownSystemSiteDispatchMapper downSystemSiteDispatchMapper;

    @Override
    public List<DownSystemSiteDispatchDetail> getBySourceDownSystemSiteId(Integer sourceDownSystemSiteId) {
        return downSystemSiteDispatchMapper.getBySourceDownSystemSiteId(sourceDownSystemSiteId);
    }

    @Override
    public boolean add(DownSystemSiteDispatch req) {
        return downSystemSiteDispatchMapper.add(req)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return downSystemSiteDispatchMapper.delete(id)>0;
    }
}
