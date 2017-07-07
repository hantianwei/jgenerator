# jgenerator
  * 基于 FreeMarker 的适用于Mybatis的通用代码生成器
  * 适用只是项目自带模板适应于Mybatis，主程序为通用代码生成器，修改模板即可支持自定义项目

# 配置

  ``` xml
  DB_SERVER = 127.0.0.1
  DB_PORT = 3306
  DB_USER = root
  DB_PASSWORD = abc@123
  DB_NAME = testdrive
  PACKAGE_ROOT_NAME= com.hantianwei.testdb
  PACKAGE_ROOT_PATH = com.hantianwei.testdb
  PACKAGE_MODEL_NAME = model
  PACKAGE_MODEL_PATH = \\testcode\\testcode-domain\\src/main/java/com/hantianwei/testcode/domain/
  PACKAGE_DAO_NAME = dao
  PACKAGE_DAO_PATH = /testcode/testcode-dao/src/main/java/com/hantianwei/testcode/dao/
  PACKAGE_SERVICE_NAME = service
  PACKAGE_SERVICE_PATH = /testcode/testcode-service/src/main/java/com/hantianwei/testcode/service/impl/
  PACKAGE_ISERVICE_NAME = service
  PACKAGE_ISERVICE_PATH = /testcode/testcode-service/src/main/java/com/hantianwei/testcode/service/
  PACKAGE_MAPPER_PATH = /testcode/testcode-dao/src/main/resources/mapping/
  TRIM_STRINGS = true
  ```

# 执行

  ``` java
  java -jar jgenerator.jar config.properties
  ```

  * 可以多配置，在执行时指定用哪个配置即可
  * 如果程序有BUG或好的建议请提给我，谢谢!
