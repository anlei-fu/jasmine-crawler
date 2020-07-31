/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.mapper;

import com.github.pagehelper.Page;
import com.jasmine.crawler.common.pojo.entity.Dictionary;
import com.jasmine.crawler.web.admin.pojo.param.AddDictionaryParams;
import com.jasmine.crawler.web.admin.pojo.param.UpdateDictionaryParams;
import com.jasmine.crawler.web.admin.pojo.req.GetDictionaryPageReq;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface DictionaryMapper {

    int add(AddDictionaryParams param);

    int deleteById(@Param("id") Integer id);

    int updateById(UpdateDictionaryParams param);

    Dictionary getById(@Param("id") Integer id);

    Page<Dictionary> getPage(GetDictionaryPageReq req);

    int deleteBatch(@Param("list") List<Integer> ids);
}
