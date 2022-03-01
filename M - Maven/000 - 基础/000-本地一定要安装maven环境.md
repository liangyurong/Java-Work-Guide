### 1.关键字

本地maven环境、安装maven环境。

### 2.为什么本地要安装maven环境

加载依赖的时候会比较快。

### 3.操作步骤（将安装包放在D盘的lyr文件夹的Maven文件夹）

- maven包下载连接：https://maven.apache.org/download.cgi

    下载的是Binary Zip archive对应的apache-maven-3.8.4-bin.zip

- 新建Maven安装包，将压缩包放在里面，然后解压到当前文件夹，会生成apache-maven-3.5.0文件夹。

- 进入apache-maven-3.5.0文件夹，新建一个repository文件夹，ok。

- 进入apache-maven-3.5.0文件夹的conf文件夹，打开setting.xml文件，将<localRepository>里的路径改为自己电脑的对应路径，如下图setting.xml的红字部分。

### 4.setting.xml

localRepository里面设置的是本地的repository路径。

里面的注释很多，可以直接删掉
```xml
<?xml version="1.0" encoding="UTF-8"?>

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <localRepository>D:\lyr\Maven\apache-maven-3.5.0\repository</localRepository>  

 <!--设置阿里镜像仓库-->
 <mirrors>
     <mirror>
      <id>alimaven</id>
      <mirrorOf>central</mirrorOf>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
    </mirror>
  </mirrors>
<profiles>
  <profile>
    <id>jdk18</id>
    <activation>
      <activeByDefault>true</activeByDefault>
      <jdk>1.8</jdk>
    </activation>
    <properties>
      <maven.compiler.source>1.8</maven.compiler.source>
      <maven.compiler.target>1.8</maven.compiler.target>
      <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
    </properties>
  </profile>
</profiles>
</settings>

```
### 5.设置了setting.xml文件之后，**以后都不需要**在pom.xml添加以下代码

```xml
<repositories>  
        <repository>  
            <id>alimaven</id>  
            <name>aliyun maven</name>  
            <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
            <releases>  
                <enabled>true</enabled>  
            </releases>  
            <snapshots>  
                <enabled>false</enabled>  
            </snapshots>  
        </repository>  
</repositories>  

```
### 6.当前项目设置
- File -> setting -> Build,Exclusion.Deployment -> Maven
- 更改Maven home dirctory，也就是刚刚安装的maven路径。
- 下面的User settings file和Local repository也要设置为自己刚刚设置的路径。

![](https://github.com/liangyurong/imageHouse/blob/master/%E5%9B%BE%E7%89%87%E5%BA%93/012.png)

### 7.如果以后项目也想使用现在的设置，也就是使用国内的阿里镜像，可以这么做。

- file - other settings -> setting for  new projects ->maven，按照下图设置即可

![](https://github.com/liangyurong/imageHouse/blob/master/%E5%9B%BE%E7%89%87%E5%BA%93/013.png)
