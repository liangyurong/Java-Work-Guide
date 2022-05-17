## UUID防止误删

uuid可以使用java的UUID生成一个随机的不重复字符串

set k1 uuid nx ex 10

### 为什么需要uuid

比如有ABC三台服务器，每个锁的释放时间是10s

当A执行，上锁，但是由于某些原因停止操作了，于是10s过去了，锁被自动释放。当A恢复执行，然后手动释放锁，此时释放的是B或者C的锁。

### uuid分布式锁的执行过程

1、上锁之前，生成String uuid = UUID.randomUUID.yoString();

2、上锁

3、执行业务操作

4、获取锁，判断当前锁的内容是否和uuid相同，相同的话则释放锁