### 项目结构

![](https://github.com/liangyurong/imageHouse/blob/master/%E5%9B%BE%E7%89%87%E5%BA%93/014.png)

### navicat中创建student表

```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` double NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```

### 1.新建maven工程，不用导入其他模块。命名为springboot-mybatis。

### 2. 在pom.xml添加依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.lyr</groupId>
    <artifactId>springboot-mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!--导入父类依赖-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.3.RELEASE</version>
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

        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.6</version>
        </dependency>

        <!--mybatis-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>

        <!--数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.11</version>
        </dependency>
    </dependencies>

    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.yml</include>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>

</project>
```

### 3.在application.yml中配置数据库信息和整合MyBatis

db是数据库名称。

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/db?serverTimezone=GMT&useUnicode=true&characterEncoding=utf8
    username: root
    password: 123456

mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.lyr.entity
```

### 4. 实体类Student

```java
package com.lyr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private double score;
    private Date birthday;
}

```

### 5. StudentDao接口

```java
package com.lyr.dao;

import com.lyr.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Component
public interface StudentDao {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void update(Student student);
    void deleteById(Integer id);
}
```

### 6. StudentMapper.xml映射文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--
    namespace:是接口的全类名
    增删改的返回类型都是int，resultType的返回值可以不写
    findAll()方法，查找全部学生，返回值类型是List，但是List的泛型写的是Student，因此resultType写的是Student
-->
<mapper namespace="com.lyr.dao.StudentDao">
    <!--返回值类型写的是集合里面泛型的类型，也就是Student-->
    <select id="findAll" resultType="com.lyr.entity.Student">
        select * from student
    </select>

    <select id="findById" parameterType="int" resultType="com.lyr.entity.Student">
        select * from student where id=#{id}
    </select>

    <insert id="save" parameterType="com.lyr.entity.Student">
        insert into student(name,score,birthday) values (#{name},#{score},#{birthday})
    </insert>

    <delete id="deleteById" parameterType="int">
        delete from student where id=#{id}
    </delete>

    <update id="update" parameterType="com.lyr.entity.Student">
        update student set name = #{name},score = #{score},birthday=#{birthday} where id=#{id}
    </update>
</mapper>

```

### 7. Controller

```java
package com.lyr.controller;

import com.lyr.dao.StudentDao;
import com.lyr.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/findAll")
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return studentDao.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentDao.save(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentDao.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        studentDao.deleteById(id);
    }

}

```

### 8. 启动类

```java
package com.lyr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lyr.dao")
@SpringBootApplication
public class RunApp {
    public static void main(String[] args) {
        SpringApplication.run(RunApp.class,args);
    }
}
```

### 9. 以上代码均在PostMan中测试通过

### 10.插件推荐

Free MyBatis Plugin。可以很方便追踪dao的方法跳转。
