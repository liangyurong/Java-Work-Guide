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


### explain显示的列

possible_keys 理论上用到的索引

key 实际用到的索引

type 采用什么类型去扫描字段。all代表全表索引

extra 额外动作（using where代表使用了where查询）