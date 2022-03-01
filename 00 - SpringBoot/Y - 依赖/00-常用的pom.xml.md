
### pom.xml设置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--常用的版本号-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.6.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.sdyb</groupId>
    <artifactId>gdydops</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>
    <name>gdydops</name> <!--项目名称-->
    <description>这里写上你的项目的描述</description>
 
    <!--不使用版本仲裁的默认版本号，而是使用自己定义的版本号-->
    <properties>
        <java.version>1.8</java.version>
        <mybatis-plus.version>3.1.0</mybatis-plus.version>
        <mybatis-plus-boot.version>3.3.1</mybatis-plus-boot.version>
        <druid.version>1.1.16</druid.version>
        <pagehelper.version>1.2.10</pagehelper.version>
    </properties>

    <dependencies>

        <!--必要-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!--常用依赖-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!--必要-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--本地运行时要注释掉-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <!--本地运行时要注释掉-->

        <!--aop 做日志管理-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>

        <!-- Mybatis-plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>

        <!--Mybatis-plus代码生成器-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>${mybatis-plus.version}</version>
        </dependency>

        <!--for SqlServer-->
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>sqljdbc4</artifactId>
            <version>4.0</version>
        </dependency>
          <!--for SqlServer-->
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>8.1.0.jre8-preview</version>
        </dependency>

    </dependencies>

    <build>
        <finalName>gdydops</finalName>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                    <!-- 
                      指明编译源代码时使用的字符编码，maven编译的时候默认使用的GBK编码，
                      通过encoding属性设置字符编码，告诉maven这个项目使用UTF-8来编译 
                    -->
                    <encoding>utf8</encoding>
                </configuration>
            </plugin>
       
            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <skipTests>true</skipTests>
                </configuration>
            </plugin>
           
        </plugins>
        <resources>
            <resource>
                <directory>src/main/java</directory> 
                <includes>
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <!--值定义了资源的路径。构建的默认目录是${basedir}/src/main/resources-->
                <directory>src/main/resources</directory> 
                <!--includes表示仅读取directory文件夹下includes中指定的文件或文件夹的内容，即in的意思-->
                <!--一组文件匹配模式，指定目录中要包括的文件，使用*作为通配符。-->
                <includes> 
                    <include>**/*.xml</include>
                    <include>**/*.properties</include>
                    <include>**/*.xls</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>

</project>

```

### 参数解读

- POM 是 Project Object Model 的缩写，即项目对象模型。

- pom.xml 就是 maven 的配置文件，用以描述项目的各种信息。

- groupId, artifactId, version - 和基本配置中的 groupId、artifactId、version 意义相同。

- packaging - 项目的类型，描述了项目打包后的输出，默认是 jar。常见的输出类型为：pom, jar, maven-plugin, ejb, war, ear, rar, par。

- scope - 此元素指的是任务的类路径（编译和运行时，测试等）以及如何限制依赖关系的传递性。有 5 种可用的限定范围：
  - compile - 如果没有指定 scope 标签，maven 默认为这个范围。编译依赖关系在所有 classpath 中都可用。此外，这些依赖关系被传播到依赖项目。
  - provided - 与 compile 类似，但是表示您希望 jdk 或容器在运行时提供它。它只适用于编译和测试 classpath，不可传递。
  - runtime - 此范围表示编译不需要依赖关系，而是用于执行。它是在运行时和测试 classpath，但不是编译 classpath。
  - test - 此范围表示正常使用应用程序不需要依赖关系，仅适用于测试编译和执行阶段。它不是传递的。
  - system - 此范围与 provided 类似，除了您必须提供明确包含它的 jar。该 artifact 始终可用，并且不是在仓库中查找。
  
- optional - optional 让其他项目知道，当您使用此项目时，您不需要这种依赖性才能正常工作。

- exclusions - 包含一个或多个排除元素，每个排除元素都包含一个表示要排除的依赖关系的 groupId 和 artifactId。与可选项不同，可能或可能不会安装和使用，排除主动从依赖关系树中删除自己。

- resources，资源的配置。资源文件通常不是代码，不需要编译，而是在项目需要捆绑使用的内容。
