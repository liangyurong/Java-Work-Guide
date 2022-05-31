package com.demo.多线程.创建线程;

// 打断sleep阻塞的线程，会抛出sleep interrupted异常

public class Test {

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{
            try {
                System.out.println("线程1 sleep ing...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1");

        t1.start();              // 启动线程1
        Thread.sleep(500);       // main线程阻塞1s，因此线程1能够获取cpu时间片去执行代码
        t1.interrupt();          // main线程执行该行代码，线程1的sleep阻塞被打断，抛出异常：sleep interrupted
        System.out.println("打断标记: "+t1.isInterrupted()); // t1.interrupt()方法会清空打断标记，因此返回false

    }

}
