
## <scope>provided</scope>

当子工程中引入某个依赖时，可见其设置<scope>provided</scope>，那么后续依赖该工程的所有项目会可能出现找不到这个依赖，原因是：

1.provided是没有传递性的。即，如果你依赖的某个jar包，它的某个jar的范围是provided，那么该jar不会在你的工程中依靠jar依赖传递加入到你的工程中。

2.provided具有继承性，上面的情况，如果需要统一配置一个组织的通用的provided依赖，可以使用parent，然后在所有工程中继承

## tomcat中使用<scope>provided</scope>

1、spring boot 项目是自带tomcat 的，但是我们有时候是需要把项目打包成war 然后放到独立的tomcat中运行的

2、这个时候我们就需要将它自带的tomcat给排除开，这时候我们就可以使用<scope>provided</scope>来实现

本地运行项目：由于需要使用自带的tomcat，所以需要注释掉下面的依赖

部署war包：需要引入该依赖，在打包的时候排除掉自带的tomcat

```xml
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
</dependency>
```

##  lombok中使用<scope>provided</scope>

1、因为在加上@data等注解的地方，lombok在编译阶段就会把get和set等方法编译成class源代码，

2、而在正式编译完成之后，是不需要lombok的，这里的provided就是保证代码编译之后，lombok.jar不会编译到最后的项目文件中

```xml
<dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>11.18.12</version>
       <scope>provided</scope>
 </dependency>
```


