package com.hantianwei.generator.util;

import com.hantianwei.generator.model.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by tianwei on 2017/6/26.
 */
public class StringUtil {
    /**
     * 把数据库中的字段转换为变量类型
     * 如（user_id ----> userId）
     *
     * @param field
     * @return
     */
    public static String convertField(String field) {
        //分隔符
        char separator = '_';
        //转化为小写
        String variable = field.toLowerCase();

        if (variable.indexOf(separator) > -1) {
            char[] varArray = variable.toCharArray();
            for (int i = 0; i < varArray.length; i++) {
                if (varArray[i] == separator && i < varArray.length - 1) {
                    varArray[i + 1] = Character.toUpperCase(varArray[i + 1]);
                }
            }
            variable = new String(varArray).replaceAll("_", "");
        }

        return variable;

    }

    /**
     * 获取字符串型的类型名
     *
     * @param type
     * @return
     */
    public static String convertToJavaType(String type) {
        Map<String,String> map = getTypesJava();
        if(map.containsKey(type)){
            return map.get(type);
        }else {
            return "String";
        }
    }

    private static Map<String, String> getTypesJava() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("VARCHAR", "String");
        map.put("CHAR", "String");
        map.put("BLOB", "byte[]");
        map.put("TEXT", "String");
        map.put("INTEGER", "Integer");
        map.put("INT", "Integer");
        map.put("SMALLINT", "Short");
        map.put("MEDIUMINT", "Integer");
        map.put("BIT", "Boolean");
        map.put("BIGINT", "Long");
        map.put("FLOAT", "Float");
        map.put("DOUBLE", "Double");
        map.put("DECIMAL", "BigDecimal");
        map.put("BOOLEAN", "Integer");
        map.put("TINYINT", "Byte");
        map.put("DATE", "Date");
        map.put("TIME", "Time");
        map.put("DATETIME", "Date");
        map.put("TIMESTAMP", "Timestamp");
        map.put("YEAR", "Date");
        return map;
    }

    public static String convertToJdbcType(String type) {
        Map<String,String> map = getTypesJdbc();
        if(map.containsKey(type)){
            return map.get(type);
        }else {
            return "String";
        }
    }

    private static Map<String, String> getTypesJdbc() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("VARCHAR", "VARCHAR");
        map.put("CHAR", "CHAR");
        map.put("BLOB", "BINARY");
        map.put("TEXT", "LONGVARCHAR");
        map.put("INTEGER", "INTEGER");
        map.put("INT", "INTEGER");
        map.put("SMALLINT", "SMALLINT");
        map.put("MEDIUMINT", "INTEGER");
        map.put("BIT", "BIT");
        map.put("BIGINT", "BIGINT");
        map.put("FLOAT", "REAL");
        map.put("DOUBLE", "DOUBLE");
        map.put("DECIMAL", "DECIMAL");
        map.put("TINYINT", "TINYINT");
        map.put("DATE", "DATE");
        map.put("TIME", "TIME");
        map.put("DATETIME", "TIMESTAMP");
        map.put("TIMESTAMP", "TIMESTAMP");
        map.put("YEAR", "DATE");
        return map;
    }

    public static Field getFieldPk(List<Field> fieldList){
        Field field = new Field();
        for (Field item:fieldList) {
            if(item.getIsPk()==1){
                field=item;
                break;
            }
        }
        return field;
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
