## 脏读

AB事务都是“读未提交”

A事务，首先执行，但是没commit

    set session transaction isolation level Read UNCOMMITTED;
    start transaction;
    update buy set name = '1121' where id =1;
    select * from buy;

此时B事务执行

    set session transaction isolation level Read UNCOMMITTED;
    start transaction;
    select * from buy;
    commit;
    // 查到id=1的name为1121

A事务继续执行

    rollback;
    select * from buy;
    // 查到id=1的name为1

此时B事务执行

    set session transaction isolation level Read UNCOMMITTED;
    start transaction;
    select * from buy;
    commit;
    // 查到id=1的name为1

### 分析

B事务在A事务没有提交的时候，能够读取到A没有提交的数据