package com.hantianwei.generator.service;

import com.hantianwei.generator.model.Field;
import com.hantianwei.generator.model.Table;

import java.util.List;
import java.util.Map;

/**
 * Created by tianwei on 2017/6/27.
 */
public interface IDataService {
    /**
     * 根据表名获取Vo模板要用的Map型数据
     *
     * @param table:表
     * @param  fieldList:列
     * @return 返回值
     */
    Map<String, Object> getDbTemplateData(Table table, List<Field> fieldList);
}
