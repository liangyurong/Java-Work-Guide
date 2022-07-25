## JDK1.8的ConcurrentHashMap

使用数组+链表+红黑树实现的

通过cas和synchronized来实现线程安全

锁粒度更小。查询性能更好

为什么锁粒度更小？

为什么查询性能更高？

    因为有红黑树


