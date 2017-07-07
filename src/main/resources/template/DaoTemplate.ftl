package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_DAO_NAME};

import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}.${tableProName?cap_first};
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
* -------------------------------------------------------------------------------
* 功能描述：	代码处成器生成
*
* 创建人：　	代码生成
* 创建日期：	${.now}
* 创建说明： 	${ tableProName?cap_first }数据操作
*
* 修改人：　
* 修改日期：
* 修改说明：
*
* -------------------------------------------------------------------------------
*/

@Repository
public interface ${tableProName?cap_first}Dao {

	${fieldPk.type} add(@Param("${tableProName}") ${tableProName?cap_first} ${tableProName});

	void update(@Param("${tableProName}") ${tableProName?cap_first} ${tableProName});

	void remove(@Param("${fieldPk.proName}") ${fieldPk.type} ${fieldPk.proName});

	${tableProName?cap_first} getByUserId(@Param("${fieldPk.proName}") ${fieldPk.type} ${fieldPk.proName});

}