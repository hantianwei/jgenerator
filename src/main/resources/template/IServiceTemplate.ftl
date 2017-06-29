package ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_ISERVICE_NAME};

/**
* -------------------------------------------------------------------------------
* 功能描述：	代码处成器生成
*
* 创建人：　	代码生成
* 创建日期：	${.now}
* 创建说明： 	${ tableProName?cap_first }业务逻辑接口
*
* 修改人：　
* 修改日期：
* 修改说明：
*
* -------------------------------------------------------------------------------
*/

import ${config.PACKAGE_ROOT_NAME}.${config.PACKAGE_MODEL_NAME}.${tableProName?cap_first};
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface I${tableProName?cap_first}${config.PACKAGE_SERVICE_NAME?cap_first} {

    ${tableProName?cap_first} add(${tableProName?cap_first} ${tableProName});

    void update(${tableProName?cap_first} ${tableProName});

    void remove(${fieldPk.type} ${fieldPk.proName});

    ${tableProName?cap_first} getBy${fieldPk.proName?cap_first}(${fieldPk.type} ${fieldPk.proName});

}