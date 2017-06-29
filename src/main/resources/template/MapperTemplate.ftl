<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_DAO_NAME}.${tableName?cap_first}${config.PACKAGE_DAO_NAME?cap_first}">
    <resultMap id="${tableName?cap_first}BaseMap" type="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}.${tableName?cap_first}">
    <#list fieldList as pro>
        <#if pro.isPk == 1>
        <id column="${pro.name}" property="${pro.proName}" jdbcType="${pro.jdbcType}"/>
        <#else>
        <result column="${pro.name}" property="${pro.proName}" jdbcType="${pro.jdbcType}"/>
        </#if>
    </#list>
    </resultMap>

    <insert id="add" useGeneratedKeys="true" keyProperty="${fieldPk.name}" parameterType="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}.${tableName?cap_first}">
        INSERT INTO ${tableName}(<#list fieldList as pro><#if pro.isIdentity==0>${pro.name}<#if pro_has_next>,</#if></#if></#list>) VALUES(<#list fieldList as pro><#if pro.isIdentity==0>${r'#'}{${pro.proName}}<#if pro_has_next>,</#if></#if></#list>)
    </insert>

    <update id="update"  parameterType="${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}.${tableName?cap_first}">
        UPDATE
            ${tableName}
        SET
        <#list fieldList as pro>
            <#if pro.isIdentity==0>
            ${pro.name} = ${r'#'}{${pro.proName}}<#if pro_has_next>,</#if>
            </#if>
        </#list>
        WHERE
            ${fieldPk.name}=${r'#'}{${fieldPk.proName}}
    </update>

    <delete id="remove" parameterType="${fieldPk.type}">
        DELETE FROM ${tableName} WHERE ${fieldPk.name}=${r'#'}{${fieldPk.proName}}
    </delete>

    <select id="getBy${fieldPk.proName?cap_first}" parameterType="java.lang.Long" resultMap="${tableName?cap_first}BaseMap">
        SELECT
        <#list fieldList as pro>
            ${pro.name}<#if pro_has_next>,</#if>
        </#list>
        FROM
            ${tableName}
        WHERE
            ${fieldPk.name}=${r'#'}{${fieldPk.proName}}
    </select>

</mapper>
