package com.demo.多线程.创建线程;

public class Test {

    public static void main(String[] args) throws Exception {

        Room room = new Room();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        room.print();

    }
}

// 将操作放在类里面，更符合面向对象原则
// 对共享资源的保护，应该由类的内部去执行操作
class Room{
    private int a = 0;

    public void increment(){
        synchronized (this){
            a++;
            System.out.println(Thread.currentThread().getName()+" : a = "+a);
        }
    }

    public void decrement(){
        synchronized (this){
            a--;
            System.out.println(Thread.currentThread().getName()+" : a = "+a);
        }
    }

    public void print(){
        System.out.println("a = "+a);
    }

}

