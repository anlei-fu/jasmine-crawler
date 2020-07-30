package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SiteAccountMapper {
    List<SiteAccount> getBlockedAccount();

    void changeEnableStatusBatch(@Param("list") List<Integer> ids, @Param("status") Integer status);

    List<SiteAccount> getAccountsToEnable();

    void increaseCurrentUseCount(@Param("id") Integer id);

    void decreaseCurrentUseCount(@Param("id") Integer id);
}
