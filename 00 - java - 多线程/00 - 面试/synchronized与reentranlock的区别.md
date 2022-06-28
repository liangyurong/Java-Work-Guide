

### synchronized和ReentrantLock的区别

1、synchronized是一个关键字，ReentrantLock是一个类

2、synchronized会自动的加锁与释放锁，ReentrantLock需要程序员手动加锁与释放锁

3、synchronized的底层是JVM层面的锁，ReentrantLock是API层面的锁

4、synchronized是非公平锁，ReentrantLock可以选择公平锁或非公平锁

    new ReentrantLock()里面通过设置true false来设置

5、synchronized锁的是对象，锁信息保存在对象头中，ReentrantLock锁的是线程，通过代码中int类型的state标识来标识锁的状态

6.synchronized底层有一个锁升级的过程

    一开始是偏向锁，当有多个线程进行竞争，会升级为轻量级锁。

    线程的锁自旋达到阈值，会升级为重量级锁