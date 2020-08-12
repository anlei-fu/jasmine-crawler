/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.mapper.CrawlerMapper;
import com.jasmine.crawler.web.admin.pojo.param.UpdateCrawlerParams;
import com.jasmine.crawler.web.admin.pojo.req.AddCrawlerReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCrawlerPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlerBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlerReq;
import com.jasmine.crawler.web.admin.service.CrawlerService;
import com.jasmine.crawler.web.admin.utils.PageHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Autowired
    private CrawlerMapper crawlerMapper;

    @Override
    public boolean add(AddCrawlerReq req) {
        return crawlerMapper.add(req) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return crawlerMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Integer id, UpdateCrawlerReq req) {
        UpdateCrawlerParams params = new UpdateCrawlerParams(id, req);
        return crawlerMapper.updateById(params) > 0;
    }

    @Override
    public Crawler getById(Integer id) {
        return crawlerMapper.getById(id);
    }

    @Override
    public PageResult<Crawler> getPage(GetCrawlerPageReq req) {
        return PageHelperUtils.paging(req, () -> crawlerMapper.getPage(req));
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return crawlerMapper.deleteBatch(ids);
    }

    @Override
    public int disableBatch(List<Integer> ids) {
        return crawlerMapper.disableBatch(ids);
    }

    @Override
    public int enableBatch(List<Integer> ids) {
        return crawlerMapper.enableBatch(ids);
    }

    @Override
    public int updateBatch(UpdateCrawlerBatchReq req) {
        return crawlerMapper.updateBatch(req);
    }
}
