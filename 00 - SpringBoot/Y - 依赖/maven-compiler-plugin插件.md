

### 指定jdk编译版本的插件

作用：修改maven工程的jdk版本。

编译插件的作用：将.java编译成.class



```xml
<plugin>
      <artifactId>maven-compiler-plugin</artifactId>
      <configuration>
            <!-- 一般而言，target与source是保持一致的，但是，有时候为了让程序能在其他版本的jdk中运行(对于低版本目标jdk，源代码中需要没有使用低版本jdk中不支持的语法)，会存在target不同于source的情况 -->
           <source>1.7</source>  <!-- 源代码使用的开发版本 -->
           <target>1.7</target>  <!-- 需要生成的目标class文件的编译版本 -->
           <!-- 指明编译源代码时使用的字符编码，maven编译的时候默认使用的GBK编码，通过encoding属性设置字符编码，告诉maven这个项目使用UTF-8来编译  -->
            <encoding>utf8</encoding>
      </configuration>
</plugin>
```

### 使用场景 - 下载了一些工程需要编译的时候

maven是个项目管理工具，如果我们不告诉它我们的代码要使用什么样的jdk版本编译的话，它就会用maven-compiler-plugin默认的jdk版本来进行处理，这样就容易出现版本不匹配的问题，以至于可能导致编译不通过的问题。

例如代码中要是使用上了jdk1.7的新特性，但是maven在编译的时候使用的是jdk1.6的版本，那这一段代码是完全不可能编译成.class文件的。

为了处理这一种情况的出现，在构建maven项目的时候，需要配置maven-compiler-plugin插件。

### 为什么要配置这个source和target

- 因为我们在进行项目开发时, 不同机器上(一般都是多人共同开发)不同版本的jdk可能包含一些不同的方法, 以及对java的支持也会不太相同, 为了保障项目不出问题, 在团体开发中都保持jdk的一致性, 一般项目都会进行配置. 这样, 无论谁使用何种IDE进行开发时, 编译源代码都是使用pom中配置的固定jdk

- 但是, 官网上的资料显示, 并不保证一定会用配置的特定版本去编译项目, 通常情况下, 也是不会出问题的. 不过为了避免因为jdk不同导致的问题, 尽量保证本机和项目中使用的jdk版本相同吧!
