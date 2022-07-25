## 伴生对象Condition

重入锁的伴生对象Condition提供了await()和signal()的功能，可以用于线程间消息通信。


Condition表示一个等待状态

两个方法

    await()

    signal

一个Lock对象可以关联多个Condition对象，多个线程可以被绑定到不同的Condition对象，这样子就可以分组唤醒


