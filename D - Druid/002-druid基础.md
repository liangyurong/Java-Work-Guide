

### 什么是Druid？

大数据实时统计分析数据存储。

### 为什么要用druid？

主要是稳定安全。那直接连接就不稳定安全了吗？直接连接有什么缺点？

### 项目中一直以来都是用Druid吗？还是某个时间节点才使用Druid的？是因为什么原因呢？

### 连接池的作用是什么？ 

连接池的作用就是先建立一部分可以随用随取的连接。

### application.properties中的那些参数是什么意思？

```text
# 初始化连接数大小
spring.datasource.druid.initial-size=3

# 最小连接数
spring.datasource.druid.min-idle=3

# 最大连接数
spring.datasource.druid.max-active=10

# 连接超时时间
spring.datasource.druid.max-wait=60000
```






