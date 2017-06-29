package com.hantianwei.generator.service.impl;

import com.hantianwei.generator.model.Field;
import com.hantianwei.generator.model.Table;
import com.hantianwei.generator.service.IDataService;
import com.hantianwei.generator.util.FreeMakerUtil;
import com.hantianwei.generator.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianwei on 2017/6/26.
 */
public class DataService implements IDataService {

    /**
     * 根据表名获取模板要用的Map型数据
     * (带有列信息)
     *
     * @param table
     * @return
     */
    public Map<String, Object> getDbTemplateData(Table table, List<Field> fieldList) {
        Map<String, Object> templateData = new HashMap<String, Object>();
        templateData.put("tableName", table.getName());
        templateData.put("tableProName", table.getProName());
        templateData.put("fieldList", fieldList);
        templateData.put("fieldPk", StringUtil.getFieldPk(fieldList));
        templateData.put("config", FreeMakerUtil.useStaticPackage("com.hantianwei.generator.model.Config"));
        return templateData;
    }

}
