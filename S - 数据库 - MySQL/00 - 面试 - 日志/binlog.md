## binlog 二进制日志

可以简单理解为：存储着每条变更的SQL语句

### 应用

1、可以通过binlog来对数据进行恢复

2、可以用于主从复制中，从库利用主库上的 binlog 进行重播，实现主从同步。用于数据库的基于时间点、位点等的还原操作。

### binlog 的模式

三种：Statement、Row、Mixed