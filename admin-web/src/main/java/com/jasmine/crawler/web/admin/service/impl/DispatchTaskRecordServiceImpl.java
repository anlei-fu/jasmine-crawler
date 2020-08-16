/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.DispatchRecord;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.DispatchTaskRecordMapper;
import com.jasmine.crawler.web.admin.pojo.req.GetDispatchTaskRecordPageReq;
import com.jasmine.crawler.web.admin.service.DispatchTaskRecordService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchTaskRecordServiceImpl implements DispatchTaskRecordService {

    @Autowired
    private DispatchTaskRecordMapper dispatchTaskRecordMapper;

    @Override
    public PageResult<DispatchRecord> getPage(GetDispatchTaskRecordPageReq req) {
        return PageHelperUtils.paging(req, () -> dispatchTaskRecordMapper.getPage(req));
    }

    @Override
    public List<DispatchRecord> getByTaskId(Integer taskId) {
        return dispatchTaskRecordMapper.getByTaskId(taskId);
    }
}
