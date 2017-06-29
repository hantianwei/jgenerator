package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_SERVICE_NAME}.impl;

/**
* -------------------------------------------------------------------------------
* 功能描述：	代码处成器生成
*
* 创建人：　	代码生成
* 创建日期：	${.now}
* 创建说明： 	${ tableProName?cap_first }业务逻辑实现
*
* 修改人：　
* 修改日期：
* 修改说明：
*
* -------------------------------------------------------------------------------
*/

import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}.${tableProName?cap_first};
import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_DAO_NAME}.${tableProName?cap_first}Dao;
import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_ISERVICE_NAME}.I${tableProName?cap_first}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ${tableProName?cap_first}Service implements I${tableProName?cap_first}Service {

	@Resource
	private ${tableProName?cap_first}Dao ${tableProName}Dao;

	public ${tableProName?cap_first} add(${tableProName?cap_first} ${tableProName}){
		${fieldPk.type} ${fieldPk.proName} = ${tableProName}Dao.add(${tableProName});
		${tableProName}.set${fieldPk.proName?cap_first}(${fieldPk.proName});
		return ${tableProName};
	}

	public void update(${tableProName?cap_first} ${tableProName}){
		${tableProName}Dao.update(${tableProName});
	}

	public void remove(${fieldPk.type} ${fieldPk.proName}){
		${tableProName}Dao.remove(${fieldPk.proName});
	}

	public User getBy${fieldPk.proName?cap_first}(${fieldPk.type} ${fieldPk.proName}){
		return ${tableProName}Dao.getBy${fieldPk.proName?cap_first}(${fieldPk.proName});
	}

}