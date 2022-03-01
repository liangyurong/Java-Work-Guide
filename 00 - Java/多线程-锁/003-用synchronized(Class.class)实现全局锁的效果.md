### synchronized(Class.class) !=synchronized(this)

synchronized加在一个类的普通方法上，那么相当于synchronized(this)

如果synchronized加在一个类的静态方法上，那么相当于synchronized(Class对象)。

### 实现全局锁

输出结果：执行一条线程，一定全部输出完结果再执行另外一条的输出结果。

如果更换为synchronized(this),则输出的顺序是无顺序的。如果是this的话，6个线程不是共享同一个对象

```java
import java.lang.Thread;
public class Test {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        MyThread t4=new MyThread();
        MyThread t5=new MyThread();
        MyThread t6=new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}


class MyThread extends Thread{
    @Override
    public void run() {
        synchronized (MyThread.class) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 200; i++) {
                System.out.println(Thread.currentThread().getName() + "==" + i);
            }
        }
    }
}
```

### 
### 
### 
### 
### 
### 
### 
### 
### 

























