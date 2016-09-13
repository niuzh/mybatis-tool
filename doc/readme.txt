一 oracle　驱动安装 maven 配置
1 下载 oracle 驱动jar。
http://pan.baidu.com/s/1i5NkULB
2 运行Maven命令 安装jar到本地仓库
mvn install:install-file -Dfile=oracle本地路径/oracle-jdbc6-11.2.0.1.0.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
例子：mvn install:install-file -Dfile=C:/Users/nzh/Documents/tool/mybatis-代码生成工具/oracle-jdbc6-11.2.0.1.0.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
3 pom 配置
<dependency>
      <groupId>com.oracle</groupId>
      <artifactId>ojdbc6</artifactId>
      <version>11.2.0</version>
</dependency>
