## 不可重复读

AB事务都是“读已提交”

A事务，首先执行，但是没commit

    set session transaction isolation level Read COMMITTED;
    start transaction;
    select * from buy;
    // 查到id=1的name为1

此时B事务执行

    set session transaction isolation level Read COMMITTED;
    start transaction;
    update buy set name = '1121' where id =1;
    select * from buy;
    commit;

A事务继续执行

    select * from buy;
    commit;
    // 查到id=1的name为1121


### 分析

A事务在同一次事务的两次查询中，查到的结果不一致，也就是不可重复读