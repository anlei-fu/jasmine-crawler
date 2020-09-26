package com.jasmine.crawler.common.util;

import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void test() throws Exception {
        for (String file : FileUtils.listFile("D:\\mysql\\mysql-8.0.21-winx64\\data")) {
            if (file.contains("binlog.") && !file.contains("index")) {
                FileUtils.deleteFile(file);
            }
        }
    }
}