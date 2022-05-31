package com.demo.多线程;

import java.util.concurrent.locks.LockSupport;

public class TestDemo {

    static Thread t1 ;
    static Thread t2 ;
    static Thread t3 ;

    public static void main(String[] args) throws Exception {

        LS ls = new LS(3);

        t1 = new Thread(()->{
            ls.print("A",t2);
        });

        t2 = new Thread(()->{
            ls.print("B",t3);
        });

        t3 = new Thread(()->{
            ls.print("C",t1);
        });

        t1.start();
        t2.start();
        t3.start();
        
        LockSupport.unpark(t1);

    }
}

class LS{

    private int loopNum;

    public LS(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String content, Thread next){
        for (int i = 0; i < loopNum; i++) {
            LockSupport.park();
            System.out.print(content);
            LockSupport.unpark(next);
        }
    }

}



