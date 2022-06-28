## sql慢查询

### 出现sql慢查询的原因有哪些


### 怎么解决

开启慢查询日志

    查看哪些sql是慢查询语句

    一个sql语句是否是慢查询，由sql执行时间决定的，一般是10s

explain sql语句

    explain select * from student where id = 1;
    // 在显示的key中看看是否为null，为null说明没有命中索引
    // key = primary，则说明使用了主键索引

