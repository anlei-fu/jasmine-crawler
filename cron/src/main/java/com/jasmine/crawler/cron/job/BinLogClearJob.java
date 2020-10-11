package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.util.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BinLogClearJob {

    /**
     * To clear mysql bin log period
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0/40 * * * *")
    public void run() throws Exception {
        for (String file : FileUtils.listFile("D:\\mysql\\mysql-8.0.21-winx64\\data")) {
            if (file.contains("binlog.") && !file.contains("index")) {
                FileUtils.deleteFile(file);
            }
        }
    }
}
