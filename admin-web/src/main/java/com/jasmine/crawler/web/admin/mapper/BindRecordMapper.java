/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.BindRecord;
import com.jasmine.crawler.web.admin.pojo.req.GetBindRecordPageReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BindRecordMapper {

    Page<BindRecord> getPage(GetBindRecordPageReq req);
}
