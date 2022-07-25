## tryLock()

```jshelllanguage
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
```

boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException

    尝试获取锁，等待timeout时间。同时，可以响应中断。

    tryLock()在JDK内部被大量的使用

