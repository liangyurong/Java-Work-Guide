package com.demo.多线程;

public class TestDemo {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Task task = new Task();

        Thread t1 = new Thread(task,"线程1");
        Thread t2 = new Thread(task,"线程2");

        t1.start();
        Thread.sleep(10);
        t2.start();

        Thread.sleep(2000);
        System.out.println("main线程睡眠2s");

        synchronized (lock){
            lock.notifyAll(); // 唤醒lock上所有等待的线程
            System.out.println("t1线程状态 = " + t1.getState()); // BLOCKED 原因：此时main线程还没释放锁，所以t1、t2还是阻塞状态
            System.out.println("t2线程状态 = " + t2.getState()); // BLOCKED 原因：此时main线程还没释放锁，所以t1、t2还是阻塞状态
            Thread.sleep(10);
        }


    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"状态 = " + Thread.currentThread().getState());
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"：获得锁");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"状态 = " + Thread.currentThread().getState());
            }
        }
    }

}

/**
    运行结果

        线程1状态 = RUNNABLE
        线程1：获得锁
        线程2状态 = RUNNABLE
        线程2：获得锁
        main线程睡眠2s
        t1线程状态 = BLOCKED
        t2线程状态 = BLOCKED
        线程2状态 = RUNNABLE
        线程1状态 = RUNNABLE

    结果分析

        线程1获得锁，输出当前状态，随后执行lock.wait()，释放资源释放锁

        线程2获得锁，输出当前状态，随后执行lock.wait()，释放资源释放锁

        main线程睡眠2s

        main线程拿到锁，唤醒所有wait的线程，但因为main线程还没释放锁，所以两个线程状态还是blocked状态

        main线程释放锁之后，t2拿到锁，执行完。释放锁，t1拿到锁，执行完。释放锁

*/

