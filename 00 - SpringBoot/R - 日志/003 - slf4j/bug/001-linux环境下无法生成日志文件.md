
### bug描述:linux环境下无法生成日志文件

```text
    在windows下可以在D:生成日志文件，在linux环境下无法在D:生成日志文件，即使有D:这个文件夹

    <!--这里可以修改日志生成位置-->
    <property name="log.path" value="D:/log/logback.log" />
                                                  <property name="LOG_HOME" value="D:/log"/>
```

### 解决：文件路径的设置问题
```text
    生成的日志文件路径：在tomcat的根目录下的log文件夹中

    <!--这里可以修改日志生成位置-->
    <property name="log.path" value="../log/logback.log" />
    <property name="LOG_HOME" value="../log"/>

```

### 星火：如果我就是想设置在root目录下的D:文件夹，那应该怎么做？



原文件：logback-spring.xml

```text
<?xml version="1.0" encoding="UTF-8"?>

<!-- Logback configuration. See http://logback.qos.ch/manual/index.html -->

<configuration debug="false" scan="true" scanPeriod="10 seconds">
    <!--<include resource="org/springframework/boot/logging/logback/base.xml"/>-->
    <contextName>logback</contextName>

    <!--这个可以有效控制控制台输出内容-->
    <logger name="org.springboot.sample" level="debug" />

    <!--这里可以修改日志生成位置-->
    <property name="log.path" value="usr/local/log/logback.log" />
    <property name="LOG_HOME" value="usr/local/log"/>

    <!--日志文件输出的文件名 这里要把value改成工程名-->
    <property name="projectName" value="orderwechatpay"/>

    <!-- 控制台输出 -->
    <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>%d{yyyy-M-d HH:mm:ss} %t %p %m%n</pattern>
        </encoder>
    </appender>

    <appender name="file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 日志记录器的滚动策略，按日期，按大小记录 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- 归档的日志文件的路径，例如今天是2013-12-21日志，当前写的日志文件路径为file节点指定，
            可以将此文件与file指定文件路径设置为不同路径，从而将当前日志文件或归档日志文件置不同的目录。
            而2013-12-21的日志文件在由LOG_HOME指定。%d{yyyy-MM-dd}指定日期格式文件夹，%i指定索引 -->
            <!--<fileNamePattern>${log.path}.%d{yyyy-MM-dd}.zip</fileNamePattern>-->
            <FileNamePattern>${LOG_HOME}/%d{yyyy-M-d}/${projectName}/logback.%i.log</FileNamePattern>
            <!--日志文件保留天数 -->
            <MaxHistory>30</MaxHistory>
            <!-- 除按日志记录之外，还配置了日志文件不能超过50M，若超过50M，日志文件会以索引0开始，
            命名日志文件，例如logback.0.log -->
            <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>50MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <!-- 追加方式记录日志 -->
        <append>true</append>
        <!-- 日志文件的格式 -->
        <encoder>
            <pattern>%d{yyyy-M-d HH:mm:ss} %p %m%n</pattern>
            <charset>utf-8</charset>
        </encoder>
    </appender>

    <!--这里需要把name改成工程名.也就是改为java包下面的主路径-->
    <logger name="com.sdyb.orderwechatpay" level="debug" additivity="false">
        <!--输出到log文件-->
        <appender-ref ref="file" />
        <!--输出到控制台-->
        <appender-ref ref="stdout"/>
    </logger>
    <!--控制台内容-->
    <root level="info">
        <!--输出到控制台-->
        <!--<appender-ref ref="stdout"/>-->
        <!--输出到log文件-->
        <!--<appender-ref ref="file" />-->
    </root>

</configuration>

```
