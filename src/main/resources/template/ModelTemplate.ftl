package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME};

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

/**
* -------------------------------------------------------------------------------
* 功能描述：	代码处成器生成
*
* 创建人：　	代码生成
* 创建日期：	${.now}
* 创建说明： 	${ tableProName?cap_first }(${tableDescription})实体
*
* 修改人：　
* 修改日期：
* 修改说明：
*
* -------------------------------------------------------------------------------
*/

public class ${ tableProName?cap_first }  {

	<#list fieldList as pro>
	private  ${pro.type} ${pro.proName}; //${pro.description}
	</#list>

	<#list fieldList as pro>
	//${pro.description}
	public ${pro.type} get${pro.proName?cap_first}() {
		return this.${pro.proName};
	}
	public void set${pro.proName?cap_first}(${pro.type} ${pro.proName}) {
	<#if config.TRIM_STRINGS && pro.type=="String">
    	this.${pro.proName} = ${pro.proName} == null ? null : ${pro.proName}.trim();
	<#else >
		this.${pro.proName} = ${pro.proName};
	</#if>
	}

	</#list>

}