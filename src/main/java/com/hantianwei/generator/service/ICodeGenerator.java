package com.hantianwei.generator.service;

import com.hantianwei.generator.model.Field;
import com.hantianwei.generator.model.Table;

import java.util.List;

/**
 * Created by tianwei on 2017/6/29.
 */
public interface ICodeGenerator {

    void generateFile(String templateName, Table table, List<Field> fieldList, String packagePath, String fileName);

    void generateFileWithDb(String templateName, Table table, List<Field> fieldList, String packagePath, String fileName);

    void generatorAllTables();
}
