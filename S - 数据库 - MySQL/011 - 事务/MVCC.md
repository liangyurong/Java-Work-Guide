## mvcc

多版本并发控制，基于“数据版本”对并发事务进行访问

MVCC主要是为了提高并发的读写性能，

### mvcc过程

生成一个ReadView，通过ReadView找到符合条件的记录版本（历史版本由undo日志构建）

查询语句只能读到在生成ReadView之前 已提交事务所做的更改，在生成ReadView之前未提交的事务或者之后才开启的事务所做的更改是看不到的。

而写操作肯定针对的是最新版本的记录，读记录的历史版本和改动记录的最新版本本身并不冲突，也就是使用MVCC时不会产生读写操作冲突。

### 普通的select语句在read committed 和 repeatable read隔离级别下会使用到mvcc读取记录

在read committed 隔离级别，一个事务在执行过程中每次执行select都会生成一个 ReadView，ReadView存在本身就保证了事务不可以读取到未提交事务所做的更改，也就避免了脏读。

    同一个事务中，有AB两个select语句。

    执行A查询的时候，生成了一个ReadView，在AB的间隙，其他事务更改了共享数据，则在B查询中，又生成了一个ReadView，这一次会读取到更改后的共享数据，一次事务两次查询得到的结果不一致，因此出现了不可重复读的现象。

在repeatable read 隔离级别，一个事务在执行过程中只有第一次执行select操作才会生成ReadView，之后的操作都会复用这个ReadView，这也就避免了脏读和不可重复读

    每次select都是用的同一个readview，因此避免了不可重复读





