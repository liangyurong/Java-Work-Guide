## JDK1.7的ConcurrentHashMap

使用数组+链表

数组分为两类

    大数组segment

    小数组HashEntry

加锁是通过给segment添加reentrantlock锁实现线程安全