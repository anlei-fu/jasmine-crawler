package com.jasmine.crawler.tool.service;


import com.jasmine.crawler.common.component.impl.WeightWrapper;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.common.util.CollectionUtils;
import com.jasmine.crawler.tool.mapper.*;
import com.jasmine.crawler.tool.model.LimitStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Component
public class DownSystemSiteTool extends LoggerSupport {

    @Autowired
    private CrawlTaskMapper crawlTaskMapper;

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Autowired
    private UrlMapper urlMapper;


    @Autowired
    private DownSystemRunLimitMapper downSystemRunLimitMapper;

    @Transactional
    public void resetConcurrency(Integer downSystemSiteId) {
        int taskDeleted = crawlTaskMapper.deleteTaskByDownSystemSite(downSystemSiteId);
        DownSystemSite downSystemSite = downSystemSiteMapper.getConcurrency(downSystemSiteId);
        info(String.format("delete %d task,currency %d", taskDeleted, downSystemSite.getTaskCurrentRunningCount()));
        downSystemSiteMapper.resetConcurrency(downSystemSiteId);
        downSystemMapper.reduceConcurrency(downSystemSite.getDownSystemId(), downSystemSite.getTaskCurrentRunningCount());
    }

    public void resetSeedUrlStatus(Integer downSystemSiteId) {
        int total = urlMapper.resetSeedUrlStatus(downSystemSiteId);
        info(String.format("reset %d seed url", total));
    }

    public void resetUrlStatus(Integer downSystemSiteId) {
        int total = urlMapper.resetUrlStatus(downSystemSiteId);
        info(String.format("reset %d seed url", total));
    }

    public void resetCachedUrlStatus(Integer downSystemSiteId) {
        int total = urlMapper.resetCachedUrlStatus(downSystemSiteId);
        info(String.format("reset %d seed url", total));
    }

    public void createLimit(Integer downSystemSiteId, Integer maxDays, Integer maxHours) {
        downSystemSiteMapper.updateLimit(downSystemSiteId, maxDays, maxHours);
        downSystemRunLimitMapper.deleteByDownSystemSiteId(downSystemSiteId);

        for (int t = 0; t < 7; t++) {
            for (int k = 0; k < 24; k++) {
                DownSystemSiteRunLimit limit = DownSystemSiteRunLimit.builder()
                        .downSystemSiteId(downSystemSiteId)
                        .weekDayType(t)
                        .hour(k)
                        .build();
                downSystemRunLimitMapper.add(limit);
            }
        }
    }

    public void balanceRunLimit(Integer downSystemId) {
        DownSystemSite downSystemSite = downSystemSiteMapper.get(downSystemId);
        if (Objects.isNull(downSystemSite) || downSystemSite.getRunLimitAllowAutoBalance() == BooleanFlag.FALSE)
            return;

        downSystemRunLimitMapper.reset(downSystemId);
        List<LimitStatistics> limits = downSystemRunLimitMapper.statistics();

        Map<Integer, List<LimitStatistics>> weekDayLimitMap = CollectionUtils.group(limits, x -> x.getWeekDayType(), x -> x);
        List<WeightWrapper<Integer>> weekDayWeights = CollectionUtils.groupCount(weekDayLimitMap, x -> (Float) (float) (int) (x.getCount()), true);
        List<WeightWrapper<Integer>> candidateWeekDays = CollectionUtils.selectTop(weekDayWeights, x -> x.getWeight(), downSystemSite.getRunLimitMaxDays(), true);

        for (WeightWrapper<Integer> weekDay : candidateWeekDays) {
            List<LimitStatistics> weekStatistics = weekDayLimitMap.get(weekDay.getKey());
            Map<Integer, List<LimitStatistics>> dayLimitMap = CollectionUtils.group(weekStatistics, x -> x.getHour(), x -> x);
            List<WeightWrapper<Integer>> hourWeights = CollectionUtils.groupCount(dayLimitMap, x -> (Float) (float) (int) (x.getCount()), true);
            List<WeightWrapper<Integer>> hourCandidates = CollectionUtils.selectTop(hourWeights, x -> x.getWeight(), downSystemSite.getRunLimitMaxHours(), true);

            for (WeightWrapper<Integer> hour : hourCandidates) {
                downSystemRunLimitMapper.enable(downSystemId, weekDay.getKey(), hour.getKey());
            }
        }
    }
}
