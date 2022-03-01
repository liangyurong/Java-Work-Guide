## 调度定义是每隔1s打印，但是任务中使用DisallowConcurrentExecution，定义需要睡眠3s再打印

结果：睡眠三秒再打印

### 任务

```jshelllanguage
package com.lyr.demo.quartz;

import org.quartz.*;
import java.util.Date;

/**
 * 定义任务
 * 使用@DisallowConcurrentExecution，禁止并发得执行同一个job定义的多个实例
 */
@DisallowConcurrentExecution
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("execute:"+new Date());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

```

### 调度

```jshelllanguage
package com.lyr.demo;

import com.lyr.demo.quartz.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public static void main(String[] args) {

        // 1、建立任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("任务名字","组")
                // 使用JobDataMap赋值
                .usingJobData("job-detail-data-key","job-data-value")
                .build();

        // 2、建立触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("触发器名称","触发器组")
                // 使用JobDataMap赋值
                .usingJobData("trigger-data-key","trigger-data-value")
                .startNow()      // 指定现在执行
                .withSchedule(   // 触发策略：间隔ns 一直执行
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()
                )
                .build();

        // 3、调度器
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}

```

### 依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.lyr</groupId>
    <artifactId>定时器Quartz</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.6.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!--Mybatis-Plus依赖-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.3.2</version>
        </dependency>

        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>

        <!--mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!-- 定时器 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-quartz</artifactId>
        </dependency>

        <!--测试-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

    </dependencies>


</project>


```
