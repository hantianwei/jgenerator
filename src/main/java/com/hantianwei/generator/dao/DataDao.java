package com.hantianwei.generator.dao;

import com.hantianwei.generator.model.Field;
import com.hantianwei.generator.model.Table;
import com.hantianwei.generator.util.JdbcUtil;
import com.hantianwei.generator.util.StringUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianwei on 2017/6/26.
 */
public class DataDao {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String sqlstr = null;

    String tableSql = "SELECT \n" +
            "\t              TABLE_NAME as name,\n" +
            "\t              TABLE_COMMENT as description \n" +
            "          FROM \n" +
            "\t              information_schema.TABLES \n" +
            "          WHERE \n" +
            "\t              TABLE_SCHEMA='%s'";

    String fildSql = "SELECT \n" +
            "\t             c.COLUMN_NAME as name,\n" +
            "\t             c.DATA_TYPE as type,\n" +
            "\t             IFNULL(c.CHARACTER_MAXIMUM_LENGTH,0) as maxLength,\n" +
            "\t             (CASE c.IS_NULLABLE WHEN 'NO' THEN 0 ELSE 1 END) as isNullable,\n" +
            "\t             (CASE WHEN t.AUTO_INCREMENT>0 AND k.COLUMN_NAME IS NOT NULL THEN 1 ELSE 0 END) as isIdentity,\n" +
            "\t             c.COLUMN_COMMENT as description,\n" +
            "\t             (CASE c.COLUMN_KEY WHEN 'PRI' THEN 1 ELSE 0 END) as isPk\n" +
            "          FROM \n" +
            "\t             information_schema.COLUMNS AS c\n" +
            "\t             INNER JOIN information_schema.`TABLES` AS t ON t.TABLE_SCHEMA=c.TABLE_SCHEMA AND t.TABLE_NAME=c.TABLE_NAME\n" +
            "\t             LEFT JOIN information_schema.KEY_COLUMN_USAGE k ON k.COLUMN_NAME=c.COLUMN_NAME AND c.TABLE_NAME=k.TABLE_NAME AND c.TABLE_SCHEMA=k.TABLE_SCHEMA\n" +
            "          WHERE \n" +
            "\t             c.TABLE_SCHEMA='%s'" +
            "\t             AND c.TABLE_NAME='%s'" +
            "          ORDER BY\n" +
            "\t             c.ORDINAL_POSITION ASC";

    /**
     * 根据表名获取所有的列信息
     *
     * @param tableSchema
     * @param tableName
     * @return List<Field>
     */
    public List<Field> getAllColums(String tableSchema, String tableName) {

        List<Field> fieldList = new ArrayList<Field>();
        JdbcUtil dbConn = new JdbcUtil();

        try {
            this.conn = dbConn.getConnection();
            this.sqlstr = String.format(fildSql, tableSchema, tableName);
            this.st = conn.createStatement();
            this.rs = this.st.executeQuery(sqlstr);
            while (rs.next()) {
                Field field = new Field();
                String fieldName = rs.getString("name");
                field.setName(fieldName);
                field.setProName(StringUtil.convertField(fieldName));
                String fieldType = rs.getString("type").toUpperCase();
                String javaType = StringUtil.convertToJavaType(fieldType);
                field.setType(javaType);
                field.setJdbcType(StringUtil.convertToJdbcType(fieldType));
                field.setMaxLength(rs.getInt("maxLength"));
                field.setIsNullable(rs.getInt("isNullable"));
                field.setIsIdentity(rs.getInt("isIdentity"));
                String desc = rs.getString("description");
                field.setDescription(desc == null ? "" : desc);
                field.setIsPk(rs.getInt("isPk"));
                fieldList.add(field);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeALL(conn, st, rs, pst);
        }
        return fieldList;

    }

    /**
     * 根据库名聂所有表
     *
     * @param tableSchema
     * @return List<Table>
     */
    public List<Table> getAllTables(String tableSchema) {
        List<Table> fieldList = new ArrayList<Table>();
        JdbcUtil dbConn = new JdbcUtil();

        try {
            this.conn = dbConn.getConnection();
            this.sqlstr = String.format(tableSql, tableSchema);
            this.st = conn.createStatement();
            this.rs = this.st.executeQuery(sqlstr);
            while (rs.next()) {
                Table table = new Table();
                String tableName = rs.getString("name");
                table.setName(tableName);
                table.setProName(StringUtil.convertField(tableName));
                String desc = rs.getString("description");
                table.setDescription(desc == null ? "" : desc);
                fieldList.add(table);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeALL(conn, st, rs, pst);
        }
        return fieldList;
    }
}