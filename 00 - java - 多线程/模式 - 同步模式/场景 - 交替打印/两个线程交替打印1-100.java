package com.demo.多线程.三个串口同时卖100张票;

// 线程AB交替输出1-100 （A1B2A3B4A5B6）

// 分析：该方法不好，两个线程是差不多类似的代码，如果是100个线程，岂不是要写100个差不多的方法？
public class Test {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA ta=new ThreadA();
        ThreadB tb=new ThreadB();
        ta.setName("线程A");
        tb.setName("线程B");
        ta.start();
        tb.start();


    }

    /**
     * 1. 执行lock.wait()，使得线程A进入等待状态，此时释放资源释放锁。锁的是lock对象。
     * 2. 释放资源后，线程B可以获得lock的锁资源，线程B开始执行。
     * 3. 线程B执行到lock.wait()之后，释放资源释放锁，线程A继续执行。依此类推。
     */
    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (lock){
                for (int i = 1; i <= 100; i += 2) {
                    lock.notify();  // 随机唤醒正在等待的线程
                    System.out.println(Thread.currentThread().getName()+"  i==" + i);
                    if(i>=100){
                        break;
                    }
                    try {
                        lock.wait(); // 当前线程进入等待
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
            synchronized (lock){
                for (int i = 2; i <= 100; i += 2) {
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+"  i==" + i);
                    if(i>=100){
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
