package com.hantianwei.generator.service.impl;


import com.hantianwei.generator.dao.DataDao;
import com.hantianwei.generator.model.Config;
import com.hantianwei.generator.model.Field;
import com.hantianwei.generator.model.Table;
import com.hantianwei.generator.service.IDataService;
import com.hantianwei.generator.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianwei on 2017/6/26.
 */
public class DataService implements IDataService {
    DataDao dataDao = new DataDao();

    /**
     * 根据表名获取模板要用的Map型数据
     * (带有列信息)
     *
     * @param table
     * @return
     */
    public Map<String, Object> getDbTemplateData(Table table, String packageName, List<Field> fieldList) {
        Map<String, Object> templateData = new HashMap<String, Object>();
        templateData.put("tableName", table.getName());
        templateData.put("tableProName", table.getProName());
        templateData.put("properties", fieldList);
        templateData.put("package", packageName);
        templateData.put("packageModel", Config.PACKAGE_ROOT_NAME + "." + Config.PACKAGE_MODEL_NAME);
        templateData.put("packageDao", Config.PACKAGE_ROOT_NAME + "." + Config.PACKAGE_DAO_NAME);
        templateData.put("packageService", Config.PACKAGE_ROOT_NAME + "." + Config.PACKAGE_SERVICE_NAME);
        templateData.put("packageIService", Config.PACKAGE_ROOT_NAME + "." + Config.PACKAGE_ISERVICE_NAME);
        templateData.put("packageIService", Config.PACKAGE_ROOT_NAME + "." + Config.PACKAGE_ISERVICE_NAME);
        templateData.put("tablePk", StringUtil.getFieldPk(fieldList));
        templateData.put("configTrimString", Config.TRIM_STRINGS);
        return templateData;
    }

}
