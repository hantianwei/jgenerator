package com.hantianwei.generator.service.impl;

import com.hantianwei.generator.dao.DataDao;
import com.hantianwei.generator.model.Config;
import com.hantianwei.generator.model.Field;
import com.hantianwei.generator.model.Table;
import com.hantianwei.generator.service.ICodeGenerator;
import com.hantianwei.generator.util.FreeMakerUtil;
import com.hantianwei.generator.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by tianwei on 2017/6/26.
 */
public class CodeGenerator implements ICodeGenerator {

    DataDao dataDao = new DataDao();

    private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();
    private static DataService dataService = new DataService();


    public void generateFile(String templateName, Table table, List<Field> fieldList, String packagePath, String fileName) {
        generateFileWithDb(templateName, table, fieldList, packagePath, fileName);
    }

    public void generateFileWithDb(String templateName, Table table, List<Field> fieldList, String packagePath, String fileName) {
        Map<String, Object> templateData = dataService.getDbTemplateData(table, fieldList);
        freeMakerUtil.generateFile(templateName, templateData, packagePath + fileName);
    }

    public void generatorAllTables() {
        List<Table> tables = dataDao.getAllTables(Config.DB_NAME);
        for (Table table : tables) {
            long startTime = System.currentTimeMillis();
            List<Field> fieldList = dataDao.getAllColums(Config.DB_NAME, table.getName());
            String tableName = StringUtil.toUpperCaseFirstOne(table.getProName());
            //这里可改为枚举控制
            generateFile("ModelTemplate.ftl", table, fieldList, Config.PACKAGE_MODEL_PATH, String.format("%s.java", tableName));
            generateFile("DaoTemplate.ftl", table, fieldList, Config.PACKAGE_DAO_PATH, String.format("%s%s.java", tableName, StringUtil.toUpperCaseFirstOne(Config.PACKAGE_DAO_NAME)));
            generateFile("ServiceTemplate.ftl", table, fieldList, Config.PACKAGE_SERVICE_PATH, String.format("%s%s.java", tableName,StringUtil.toUpperCaseFirstOne(Config.PACKAGE_SERVICE_NAME)));
            generateFile("IServiceTemplate.ftl", table, fieldList, Config.PACKAGE_ISERVICE_PATH, String.format("I%s%s.java", tableName,StringUtil.toUpperCaseFirstOne(Config.PACKAGE_SERVICE_NAME)));
            generateFile("MapperTemplate.ftl", table, fieldList, Config.PACKAGE_MAPPER_PATH, String.format("%sMapper.xml", tableName));
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("[%s]表生成完毕,用时[%d]ms", tableName, endTime - startTime));
        }
    }


}
