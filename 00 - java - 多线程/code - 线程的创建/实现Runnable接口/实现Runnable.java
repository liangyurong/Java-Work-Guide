package com.demo.多线程.创建线程;

// 线程和任务分离，更为灵活
public class RunnableTest {
    public static void main(String[] args) {
        // 任务
        Task task = new Task();
        // 线程对象
        Thread t  = new Thread(task);
        // 启动线程
        t.start();
    }
}

// 可运行的任务
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
