Thread类的静态方法。

Thread.sleep()：让当前的线程释放CPU资源，不释放锁。当前的线程指的是：Thread.currentThread()返回的线程。也就是执行Thread.sleep()这段代码的线程。

线程A如果sleep的话，只是会释放资源，让其他线程有机会执行，等到休眠时间过去，如果该线程A得到cpu的时间片，还会继续执行。

sleep方法不能指定的不同线程休眠，它只能让当前执行的线程休眠。若执行Thread.sleep(1000)方法的是main主线程，则主线程休眠。

```java
 public class Solution {
    public static void main(String[] args) throws InterruptedException {
        MyThread ta=new MyThread();
        ta.setName("线程A");
        Thread.sleep(1000);//此时执行的线程是main线程
        System.out.println(Thread.currentThread().getName());//main
        ta.start();
    }
 }

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);//此时执行的线程是线程A
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());//线程A
    }
 }
```










