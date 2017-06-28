package com.hantianwei.generator.util;

import com.hantianwei.generator.model.Config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tianwei on 2017/6/27.
 */
public class PropUtil {

    public static void loadConf(String[] args){
        if (args == null || args.length == 0) {
            Config.CONFIG_IS_LOCAL = true;
            PropUtil.loadConf(Config.CONFIG_LOCAL_PATH);
            System.out.println(String.format("加载默认配置完成：数据库[%s]",Config.DB_NAME));
        } else {
            Config.CONFIG_IS_LOCAL = false;
            Config.CONFIG_PATH = args[0];
            PropUtil.loadConf(Config.CONFIG_PATH);
            System.out.println(String.format("加载自定义配置完成：数据库[%s]",Config.DB_NAME));
        }
    }

    public static void loadConf(String path) {
        try {
            Properties props = new Properties();
            InputStream in;
            if (Config.CONFIG_IS_LOCAL) {
                in = PropUtil.class.getClassLoader().getResourceAsStream(path);
            } else {
                in = new FileInputStream(path);
            }
            props.load(in);
            Config.DB_SERVER = props.getProperty("DB_SERVER");
            Config.DB_PORT = Integer.parseInt(props.getProperty("DB_PORT"));
            Config.DB_USER = props.getProperty("DB_USER");
            Config.DB_PASSWORD = props.getProperty("DB_PASSWORD");
            Config.DB_NAME = props.getProperty("DB_NAME");
            Config.PACKAGE_ROOT_NAME = props.getProperty("PACKAGE_ROOT_NAME");
            Config.PACKAGE_ROOT_PATH = props.getProperty("PACKAGE_ROOT_PATH");
            Config.PACKAGE_MODEL_NAME = props.getProperty("PACKAGE_MODEL_NAME");
            Config.PACKAGE_MODEL_PATH = props.getProperty("PACKAGE_MODEL_PATH");
            Config.PACKAGE_DAO_NAME = props.getProperty("PACKAGE_DAO_NAME");
            Config.PACKAGE_DAO_PATH = props.getProperty("PACKAGE_DAO_PATH");
            Config.PACKAGE_SERVICE_NAME = props.getProperty("PACKAGE_SERVICE_NAME");
            Config.PACKAGE_SERVICE_PATH = props.getProperty("PACKAGE_SERVICE_PATH");
            Config.PACKAGE_ISERVICE_NAME = props.getProperty("PACKAGE_ISERVICE_NAME");
            Config.PACKAGE_ISERVICE_PATH = props.getProperty("PACKAGE_ISERVICE_PATH");
            Config.PACKAGE_MAPPER_PATH = props.getProperty("PACKAGE_MAPPER_PATH");
            Config.TRIM_STRINGS = Boolean.parseBoolean(props.getProperty("TRIM_STRINGS"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}