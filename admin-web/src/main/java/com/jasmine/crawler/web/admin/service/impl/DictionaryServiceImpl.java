/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.Dictionary;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.DictionaryMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateDictionaryParams;
import com.jasmine.crawler.web.admin.pojo.req.AddDictionaryReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDictionaryPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryReq;
import com.jasmine.crawler.web.admin.service.DictionaryService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public boolean add(AddDictionaryReq req) {
        return dictionaryMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return dictionaryMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Integer id, UpdateDictionaryReq req) {
        UpdateDictionaryParams params = new UpdateDictionaryParams(id, req);
        return dictionaryMapper.updateById(params) > 0;
    }

    @Override
    public Dictionary getById(Integer id) {
        return dictionaryMapper.getById(id);
    }

    @Override
    public PageResult<Dictionary> getPage(GetDictionaryPageReq req) {
        PageHelperUtils.startPage(req);
        Page<Dictionary> page = dictionaryMapper.getPage(req);
        return PageResult.create(req, page);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return dictionaryMapper.deleteBatch(ids);
    }

    @Override
    public int updateBatch(UpdateDictionaryBatchReq req) {
        return dictionaryMapper.updateBatch(req);
    }

    @Override
    public List<Dictionary> getAll() {
        return dictionaryMapper.getAll();
    }
}
