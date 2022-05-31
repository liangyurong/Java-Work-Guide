### wait()

wait设计的本意：让其他线程有机会获取到锁

final修饰wait()

执行obj.wait()方法让当前运行的线程等待，释放当前线程所获得的的锁。直到另一个线程在这个对象上调用notify()方法或者notifyAll()方法。此时的wait()方法的行为等同于wait(0)。

wait()方法需要放在synchronized代码块中

执行wait()方法后，当前线程会变为WATING状态。而线程执行sleep()方法后会变为TIMED_WATING状态。

进入wait的线程能够被notify和notifyAll唤醒。

wait()方法不能在static方法中使用，因为wait()方法是实例方法。

### 为什么wait()方法要放在synchronized中

不搭配的话会造成Lost Wake-UP Problem。这个是什么问题？怎么证明？

不放的话，执行会抛出异常：java.lang.IllegalMonitorStateException
