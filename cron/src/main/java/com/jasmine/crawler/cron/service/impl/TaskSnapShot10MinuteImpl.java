package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.TaskSnapShot10MinuteMapper;
import com.jasmine.crawler.cron.service.TaskSnapShot10MinuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskSnapShot10MinuteImpl implements TaskSnapShot10MinuteService {

    @Autowired
    private TaskSnapShot10MinuteMapper taskSnapShot10MinuteMapper;

    @Override
    public void snapShot10Minute(Date time) {
        taskSnapShot10MinuteMapper.snapShot10Minute(time);
    }

    @Override
    public void delete(Date time) {
        taskSnapShot10MinuteMapper.delete(time);
    }
}
