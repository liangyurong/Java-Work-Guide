## mvcc

多版本并发控制，基于“数据版本”对并发事务进行访问

    什么是数据版本？

MVCC就是为了实现读-写冲突时不加锁，而这个读指的就是快照读, 而非当前读。当前读实际上是一种加锁的操作，是悲观锁的实现

实现的三个关键点

    三个隐式字段（每行数据都会有这三个隐式的字段）

        1、事务ID（trx_id）：自增；记录创建这条记录/最后一次修改该记录的事务ID （insert,update,delete）
        2、回滚指针：指向这条记录的上一个版本（存储于rollback segment里）
        3、隐藏主键db_row_id ：如果数据表没有主键，数据库就会以此为主键（InnoDB会自动以DB_ROW_ID产生一个聚簇索引）

    undo log 回滚日志

        1、insert undo log：在insert新记录时产生的undo log, 只在事务回滚时需要，并且在事务提交后可以被立即丢弃
        2、update undo log：在进行update或delete时产生的undo log; 不仅在事务回滚时需要，在快照读时也需要；所以不能随便删除，只有在快速读或事务回滚不涉及该日志时，对应的日志才会被purge线程统一清除
        3、用于做undo log版本链：保存一行数据的版本变化。比如每条记录的name从A->B->C，那么就会产生3个版本数据

    read view

        1、是执行普通select sql语句时，mvcc提取数据的依据
        2、
        3、

当前读

    当读取的是记录的最新版本，读取时还要保证其他并发事务不能修改当前记录，会对读取的记录进行加锁

    包含：insert、uodate、delete、select...for update(写锁)、select...lock in share mode（读锁）

快照读

    不加锁的select操作，也就是普通的select语句

### mvcc过程

生成一个ReadView，通过ReadView找到符合条件的记录版本（历史版本由undo log构建）

查询语句只能读到在生成ReadView之前 已提交事务所做的更改，在生成ReadView之前未提交的事务或者之后才开启的事务所做的更改是看不到的。

而写操作肯定针对的是最新版本的记录，读记录的历史版本和改动记录的最新版本本身并不冲突，也就是使用MVCC时不会产生读写操作冲突。

### 普通的select语句在read committed 和 repeatable read隔离级别下会使用到mvcc读取记录

在read committed 隔离级别，一个事务在执行过程中每次执行select都会生成一个 ReadView，ReadView存在本身就保证了事务不可以读取到未提交事务所做的更改，也就避免了脏读。

    同一个事务中，有AB两个select语句。

    执行A查询的时候，生成了一个ReadView，在AB的间隙，其他事务更改了共享数据，则在B查询中，又生成了一个ReadView，这一次会读取到更改后的共享数据，一次事务两次查询得到的结果不一致，因此出现了不可重复读的现象。

在repeatable read 隔离级别，一个事务在执行过程中只有第一次执行select操作才会生成ReadView，之后的操作都会复用这个ReadView，这也就避免了脏读和不可重复读

    每次select都是用的同一个readview，因此避免了不可重复读





