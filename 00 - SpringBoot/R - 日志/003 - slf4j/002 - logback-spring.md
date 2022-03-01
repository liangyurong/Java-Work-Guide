
固定命名格式：logback-spring.xml

起名为logback.xml，直接就被日志框架识别了。

起名为logback-spring.xml，日志框架不直接加载日志的配置项，而是由SpringBoot解析日志配置。

SpringBoot官方也推荐使用logback-spring.xml命名。

SpringBoot实际开发中不需要配置该依赖，这是默认的日志框架。 

### 想法

日志的异步加载

日志的自动归档？

以前总是用system.out.println来输出一些数据，查看是否正确。但是这样子的代价是经常要输出，如果需要修改的话，非常不方便。

那么怎么改变这些做法呢？使用框架来记录系统运行时的一些数据

### 基础

日志输出的级别：error，warn，info，debug，trace。

日志门面：SLF4J

日志实现：Logback（SpringBoot内置）

SpringBoot的底层是SpringBoot框架，Spring框架默认使用的是JCL。SpringBoot选用SLF4J和Logback


