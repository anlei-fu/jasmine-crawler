/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.DispatchRecord;
import com.jasmine.crawler.web.admin.pojo.req.GetDispatchTaskRecordPageReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DispatchTaskRecordMapper {

    Page<DispatchRecord> getPage(GetDispatchTaskRecordPageReq req);

    List<DispatchRecord> getByTaskId(@Param("taskId") Integer taskId);
}
