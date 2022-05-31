## sleep和wait的区别

sleep是Thread的静态方法，wait是Object的方法

sleep不需要强制与synchronized配合使用，wait强制需要配合synchronized使用

sleep释放资源不释放锁

wait释放资源也释放锁

### sleep释放资源不释放锁的例子

```java
package com.demo.多线程;

// 运行结果
    // 当前时间：1653469085227,线程1获得了lock对象
    // val = 100
    // 当前时间：1653469095238,main获得了lock对象
public class TestDemo {

    // 锁
    private static Object lock = new Object();

    // 共享变量
    private static int val = 10;

    public static void main(String[] args) throws Exception {
        new Thread(()->{
            synchronized (lock){
                System.out.println("当前时间："+System.currentTimeMillis()+","+ Thread.currentThread().getName()+"获得了lock对象");
                val = 100;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();

        // 让线程1有机会先执行
        Thread.sleep(100); 

        // main线程输出共享资源 ( val=100 ,说明线程1释放了共享资源 )
        System.out.println("val = " + val);

        // main线程尝试获得锁，但是锁没被线程1释放，虽然线程1在休眠
        synchronized (lock){
            System.out.println("当前时间："+System.currentTimeMillis()+","+ Thread.currentThread().getName()+"获得了lock对象");
        }

    }
}

```