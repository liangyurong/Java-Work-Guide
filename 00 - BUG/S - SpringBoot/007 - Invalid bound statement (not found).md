
## bug

org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.sdyb.official.service.BasicService.getList

## bug说明

绑定不了某个方法

## 原因

一般都是注解有问题，或者扫描注解的问题

如果controller,service,dao层的注解都没有问题，那可能是xml的路径问题或者是启动类扫描bean问题



## 解决

### 启动类不用写一下两个注解

```jshelllanguage
@ComponentScan(basePackages = {"com.sdyb.official.*"})
@MapperScan("com.sdyb.official.*")
```

### dao类写@Mapper和@Component两个注解


### 方法3

原因：mybatis的XXXMapper.xml被漏掉

解决：在pom中添加依赖

```xml
        <build>

        <!-- 如果不添加此节点mybatis的mapper.xml文件都会被漏掉。 -->
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                    <include>**/*.yml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                    <include>**/*.yml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>

    </build>
```




















