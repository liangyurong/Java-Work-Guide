## 写锁

### 总结

s 读锁  x 写锁

s - X(阻塞)

s - s(通行)

x - x(阻塞)

x - s(阻塞)


说明：操作1和操作2均在命令行实现

### 操作1：对于同一张表，A事务使用读锁，B事务使用读锁

A事务

    begin;
    select * from student for update; // 读取到表数据

B事务

    begin;
    select * from student for share; // 进入阻塞，读取不到数据

A事务

    commit;

B事务
   
    // 当A事务commit之后，B事务才读取到数据
    commit;

### 操作2：对于同一张表，A事务使用读锁，B事务使用写锁

A事务

    begin;
    select * from student for update; // 读取到表数据

B事务

    begin;
    select * from student for update; // 进入阻塞，读取不到数据

A事务

    commit;

B事务

    // 当A事务commit之后，B事务才读取到数据
    commit;



