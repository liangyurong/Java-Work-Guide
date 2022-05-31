package com.demo.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

    public static void main(String[] args) throws Exception {

        AwaitSignal awaitSignal = new AwaitSignal(3);

        Condition ACon = awaitSignal.newCondition();
        Condition BCon = awaitSignal.newCondition();
        Condition CCon = awaitSignal.newCondition();

        Thread t1 = new Thread(()->{
            awaitSignal.print("A",ACon,BCon);
        });

        Thread t2 = new Thread(()->{
            awaitSignal.print("B",BCon,CCon);
        });

        Thread t3 = new Thread(()->{
            awaitSignal.print("C",CCon,ACon);
        });

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10);
        awaitSignal.lock();
        try{
            ACon.signalAll();
        }finally {
            awaitSignal.unlock();
        }

    }
}

class AwaitSignal extends ReentrantLock{

    private int loopNum;

    public AwaitSignal(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String content,Condition cur,Condition next){
        for (int i = 0; i < loopNum; i++) {
            lock();
            try {
                cur.await();
                System.out.print(content);
                next.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            } finally{
                unlock();
            }
        }
    }

}



