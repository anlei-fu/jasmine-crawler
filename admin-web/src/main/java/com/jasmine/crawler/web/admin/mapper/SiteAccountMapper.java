/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.web.admin.pojo.param.UpdateSiteAccountParams;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteAccountReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteAccountPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountBatchReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiteAccountMapper {

    int add(AddSiteAccountReq req);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateSiteAccountParams param);

    SiteAccount getById(@Param("id") Integer id);

    Page<SiteAccount> getPage(GetSiteAccountPageReq req);

    int deleteBatch(@Param("list") List<Integer> ids);

    int disableBatch(@Param("list") List<Integer> ids);

    int enableBatch(@Param("list") List<Integer> ids);

    int updateBatch(UpdateSiteAccountBatchReq req);
}
