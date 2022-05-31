package com.demo.多线程.创建线程;


// 原因分析：a++ 和 a-- 不是原子性操作
// 执行完 a+1，还没写入结果的时候，又执行了a-1，就会造成结果错乱

// a是多个线程的共享资源

public class Test {

     static int a = 0;

    public static void main(String[] args) throws Exception{

        // 循环次数太少的话，可能得到的结果就是0. 得让循环的次数变得足够大
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                a--;
            }
        },"t1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                a++;
            }
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Thread.sleep(1000);

        System.out.println("a = "+a); // 结果不确定

    }
}

