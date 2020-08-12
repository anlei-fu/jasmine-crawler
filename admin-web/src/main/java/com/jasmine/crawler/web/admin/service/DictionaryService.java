/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service;

import com.jasmine.crawler.common.pojo.entity.Dictionary;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddDictionaryReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDictionaryPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryReq;

import java.util.List;

public interface DictionaryService {

    boolean add(AddDictionaryReq req);

    boolean deleteById(Integer id);

    boolean updateById(Integer id, UpdateDictionaryReq req);

    Dictionary getById(Integer id);

    PageResult<Dictionary> getPage(GetDictionaryPageReq req);

    int deleteBatch(List<Integer> ids);

    int updateBatch(UpdateDictionaryBatchReq req);

    List<Dictionary> getAll();
}
