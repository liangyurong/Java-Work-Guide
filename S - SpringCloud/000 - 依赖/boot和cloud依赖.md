
### cloud和boot之间的版本有约束和依赖

H版 - boot从2.2.x起步

G版 - boot从2.1.x起步

### spring-cloud 尚硅谷

cloud Hoxton.SR1

boot 2.2.2

cloud alibaba 2.1.0

java 8

maven 3.5及其以上

mysql 5.7及其以上

### 狂神说spring-cloud 2022

```xml
    <parent>
        <artifactId>spring-boot-starter-parent</artifactId>
        <groupId>org.springframework.boot</groupId>
        <version>2.3.12.RELEASE</version>
    </parent>

    <!-- springcloud 的依赖-->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>Hoxton.SR12</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
```