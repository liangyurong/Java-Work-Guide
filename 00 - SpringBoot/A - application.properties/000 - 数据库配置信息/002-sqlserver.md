### sqlserver

```properties
## sqlserver
spring.datasource.url=jdbc:sqlserver://127.0.0.1:4711;databaseName=lyr
spring.datasource.username=admin
spring.datasource.password=123456
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
```
依赖
```xml
      <!--for SqlServer-->
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>sqljdbc4</artifactId>
            <version>4.0</version>
        </dependency>
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>8.1.0.jre8-preview</version>
        </dependency>
```
