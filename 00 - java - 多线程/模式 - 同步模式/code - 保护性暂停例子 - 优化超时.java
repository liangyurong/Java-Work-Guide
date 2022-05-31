package com.demo.多线程;

public class TestDemo {

    public static void main(String[] args) throws Exception {
        // 共享
        GuardedObject obj = new GuardedObject();

        // 线程1等待线程2的下载结果
        new Thread(()->{
            Object en = obj.get(1000);
            System.out.println(Thread.currentThread().getName()+"获取的下载结果是 ： " + en);
        },"线程1").start();

        // 线程2执行下载
        new Thread(()->{
            String result = "下载结果";
            try {
                Thread.sleep(500); // 500:获取下载结果  1500：下载超时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj.complete(result);
        },"线程2").start();
    }
}

class GuardedObject{

    // 结果
    private Object response;


    // 获取结果
    // timeout 超时时间，超过该值还没获得response对象，就退出循环
    public Object get(long timeout) {
        synchronized (this){
            long begin = System.currentTimeMillis(); // 开始时间
            long passedTime = 0;                     // 已经等待的时间
            while (response == null){
                long waitTime = timeout - passedTime;// 本次循环需要等待的时间
                if(waitTime<=0){
                    System.out.println("获取下载结果超时");
                    break;
                }
                try {
                    System.out.println(Thread.currentThread().getName() + " ：正在等待");
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
        }
        return response;
    }

    //  产生结果
    public void complete(Object response){
        synchronized (this){
            this.response = response;
            this.notifyAll();
        }
    }

}
