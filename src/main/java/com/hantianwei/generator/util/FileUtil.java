package com.hantianwei.generator.util;

import java.io.File;

/**
 * Created by tianwei on 2017/6/29.
 */
public class FileUtil {

    public static void createDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCurrentDirParent() {
        String path = System.getProperty("user.dir");
        File file = new File(path);
        return file.getParent();
    }
}
