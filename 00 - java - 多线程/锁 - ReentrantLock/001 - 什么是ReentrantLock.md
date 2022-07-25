## 什么是ReentrantLock

ReentrantLock基于AQS，在并发编程中可以实现公平锁和非公平锁，进而实现对共享资源的同步。

和synchronized一样，ReentrantLock支持可重入。但比syn更加灵活。