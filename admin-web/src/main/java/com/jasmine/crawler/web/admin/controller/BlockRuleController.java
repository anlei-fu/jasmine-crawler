package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.BlockRule;
import com.jasmine.crawler.web.admin.service.BlockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@RestController
public class BlockRuleController extends ControllerBase {

    @Autowired
    private BlockRuleService blockRuleService;

    @PostMapping(path = "/blockRule")
    public R add(@RequestBody BlockRule blockRule) {
        boolean result = blockRuleService.add(blockRule);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/blockRule/{id}")
    public R delete(@PathVariable Integer id) {
        boolean result = blockRuleService.delete(id);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/blockRule/delete/batch")
    public R deleteBatch(@RequestBody List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0)
            return failed("no rules to delete");

        int success = blockRuleService.deleteBatch(ids);
        return success(String.format("expected to delete %d rule ,actual succeed %d", ids.size(), success));
    }

    @GetMapping(path = "/blockRule/getByDownSystemSiteId/{downSystemSiteId}")
    public R<List<BlockRule>> getByDownSystemSiteId(@PathVariable Integer downSystemSiteId) {
        List<BlockRule> result = blockRuleService.getByDownSystemSiteId(downSystemSiteId);
        return responseData(result);
    }
}
