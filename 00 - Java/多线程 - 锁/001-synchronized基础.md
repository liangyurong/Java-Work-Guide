
### 基础

synchronized取得的锁都是对象锁，而不是把一段代码或者一个方法当做锁。锁住的是对象。

synchronized取得的锁可能是类的实例对象，或者是字节码文件对象。两个都是对象。

synchronized加在一个类的普通方法上，相当于synchronized(this)

synchronized加在一个静态方法上，相当于synchronized(类名.class)

只有当几个线程共享同一个对象，那么当这些线程去执行锁方法的时候才能实现线程同步。

### 锁方法在某些情况是有弊端的

当线程A调用同步方法去执行一个比较长时间的任务，那么线程B就得等待这么长时间，尽管线程B只需要1s的执行时间。

Synchronized方法时对当前对象进行加锁，而synchronized代码块是对某一个对象进行加锁

当两个并发线程访问同一个对象object中的synchronized（this）的同步代码块时，一段时间内只能有一个线程被执行，另一个线程则必须等待执行完同步代码块后才能执行该同步代码块

同步代码块是同步的，持有当前调用对象的锁

当两个并发线程访问同一个对象object中的代码时，不在同步代码块中的就是异步进行，在其中的就是同步运行。

当一个线程访问object的一个同步代码块时，其他线程对同一个object中所有其他的同步代码块的访问将被阻塞，这说明synchronized（this）使用的“对象监视器”是同一个。

当一个线程访问object的一个同步代码块时，其他线程对该object中的其他同步代码块的访问将是阻塞的。这个说明synchronized（this）使用的对象监视器是同一个。

对于非static的synchronized方法，锁的就是对象本身也就是this。

对于static方法，锁住的是字节码文件对象。静态类进内存，内存中没有本类对象，但是一定有该类对应的字节码文件对象。

synchronized只能防止多个线程同时执行一个对象的同步代码块。

对于多个对象的同步代码块，其实是异步的。

当synchronized锁住一个对象后，比如此刻执行的是线程A，若线程B也想拿到这个对象的锁，就必须等待线程A执行完成释放锁，才能再次给对象加锁，这样才达到线程同步的目的。即使两个不同的代码段，都要锁同一个对象，那么这两个代码段也不能在多线程环境下同时运行，所以在用synchronized关键字时，能缩小代码段的范围就尽量缩小，能在代码段上加同步就不要在整个方法上加同步。这叫减小锁的粒度，使代码更大程度的并发。原因是基于以上的思想，锁的代码段太长了会让别的线程等待时间过长。

synchronized加在一个类的普通方法上，那么相当于synchronized(this)

如果synchronized加在一个类的静态方法上，那么相当于synchronized(类名.Class)。

当一个线程执行的代码出现异常，其持有的锁将会自动释放。

synchronized可以保证在同一时刻，只有一个线程能够执行某一个方法或者某一个代码块。
	1. 包含两个特征：互斥性和可见性。
	2. 同步synchronized不仅可以解决一个线程看到对象处于不一致的状态，还可以保证进入同步方法或者同步代码块的每个线程，都看到由一个锁保护之前所有的修改效果。

想要同步哪个代码块，看看它属于哪一个类，然后再使用锁去锁住对应的类的对象，这样子就可以实现线程同步

### 使用synchronized的一个误区

下面的代码块，其实t1，t2，t3使用的testClass对象并不是同一个，本质上是new了三个不同的TestClass对象，因此多线程可以同时运行show()方法，因此程序输出的结果无序

```java
public class Test extends ClassLoader {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}

class TestClass {
    public synchronized void show() throws InterruptedException {
        System.out.println("test start");
        Thread.sleep(10);
        System.out.println("test stop");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            TestClass testClass = new TestClass();
            testClass.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

输出结果
test start
test start
test start
test stop
test stop
test stop
```








