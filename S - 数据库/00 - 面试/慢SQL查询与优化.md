
### 场景

数据量只有几十条，但是通过接口查询却要几十秒

### 方法1

检查网络是否堵塞

### 方法2

数据库连接池配置不合理。如果并发线程数超过了连接数，那么就会有部分线程无法获得连接而进入阻塞，等待其他线程释放连接后才能访问数据库。

怎么解决

    对系统内的堆内存以及CPU的使用情况进行监控

    怎么监控？阿里云的RDS监控？

### 方法3

    查找日志文件是否有sql相关打印




