### synchronized实现原理

其实就是通过monitorenter和monitorexit去获得锁和释放锁实现的，后续的线程会同步等待，如果一个代码块被synchronized修饰，其他线程无法获取锁，只能依次等待

synchronized是非公平锁

    也就是说，线程1，线程2，线程3依次在获取锁的时候进行阻塞

    当三个线程被唤醒去竞争锁的时候，谁能获得锁取决于jdk的底层实现原理，而不是根据先来先得的规则

实现与操作系统的Monitor监视器有关

    一个对象关联一个monitor。不同的对象关联不同的monitor

    获取类对象的monitor监视器来实现加锁

    
