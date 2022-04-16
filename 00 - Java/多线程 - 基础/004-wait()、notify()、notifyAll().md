### 一、基础

wait()，notify()，notifyAll()这三个方法都是final修饰。

### 二、wait()

执行wait()方法让当前运行的线程等待，释放当前线程所获得的的锁。直到另一个线程在这个对象上调用notify()方法或者notifyAll()方法。此时的wait()方法的行为等同于wait(0)。

wait()方法需要放在synchronized代码块中

执行wait()方法后，当前线程会变为WATING状态。而线程执行sleep()方法后会变为TIMED_WATING状态。

进入wait的线程能够被notify和notifyAll唤醒。

wait()方法不能在static方法中使用，因为wait()方法是实例方法。

为什么wait()方法要放在synchronized中
```java
不搭配的话会造成Lost Wake-UP Problem。这个是什么问题？怎么证明？

不放的话，执行会抛出异常：java.lang.IllegaMonitorStateException
```

### 三、notify()

如果有多个线程处于wait状态，随机唤醒其中一个线程。

唤醒因调用这个对象wait()方法而阻塞的线程。如果是this.wait()，那么应该使用this.notify()

只唤醒等待对象的一个线程，并且该线程开始执行。如果有多个线程在等待一个对象，这个方法只会唤醒其中的一个。至于唤醒哪一个，取决于线程管理的OS实现。

### 四、notifyAll()

唤醒所有处于wait状态的线程。

notify()与notifyAll()都不能唤醒特定的线程。

释放所有的资源和锁。

### 五、需求：使用wait和notify顺序输出[1,100]。

前提：使用wait和notify，需要有一个对象。

```java
public class Solution {
    private static final Object flag = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA ta=new ThreadA();
        ThreadB tb=new ThreadB();
        ta.setName("线程A");
        tb.setName("线程B");
        ta.start();
        tb.start();
    }

    /**
     * 1. 执行flag.wait()，使得线程A进入等待状态，此时释放资源释放锁。锁的是flag对象。
     * 2. 释放资源后，线程B可以获得flag的锁资源，线程B开始执行。
     * 3. 线程B执行到flag.wait()之后，释放锁，线程A继续执行。依此类推。
     */
    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (flag){
                for (int i = 1; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println(Thread.currentThread().getName()+"  i==" + i);
                    if(i>=100){
                        break;
                    }
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (flag){
                for (int i = 2; i <= 100; i += 2) {
                    flag.notify();
                    System.out.println(Thread.currentThread().getName()+"  i==" + i);
                    if(i>=100){
                        break;
                    }
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

```








