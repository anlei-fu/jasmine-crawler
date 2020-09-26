package com.jasmine.crawler.common.util;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

    public static void createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            file.createNewFile();
    }

    public static void createFolder(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            file.mkdir();
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists())
            file.delete();
    }

    public static void deleteFolder() {

    }

    public static String readAllText(String path) {
        return null;
    }

    public static void writeAllText(String path, String text) {

    }

    public static void appendAllText(String path, String text) {

    }

    public static List<String> listFile(String folder) throws Exception {
        File f = new File(folder);
        if (!f.isDirectory())
            throw new Exception(String.format("folder(%s) is not a directory", folder));

        List<String> result = new LinkedList<>();
        for (final File subFile : f.listFiles()) {
            if (subFile.isFile())
                result.add(subFile.getAbsolutePath());
        }

        return result;
    }

    public static List<String> listFolder(String folder) throws Exception {
        File f = new File(folder);
        if (!f.isDirectory())
            throw new Exception(String.format("folder(%s) is not a directory", folder));

        List<String> result = new LinkedList<>();
        for (final File subFile : f.listFiles()) {
            if (subFile.isDirectory())
                result.add(subFile.getAbsolutePath());
        }

        return result;
    }
}
