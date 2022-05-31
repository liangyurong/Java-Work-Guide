package com.demo.多线程.创建线程;

// 线程启动后，在while循环一直打印输出“执行监控记录...”
// 如果线程被打断，则退出for循环打印
// 如果线程sleep中被打断，则应该重新设置打断标志
public class JoinTest {

    public static void main(String[] args) throws Exception{
        ThreadMonitor t = new ThreadMonitor();
        t.start();          // 启动线程1，并在while循环中打印监控信息
        Thread.sleep(2000); // main线程休眠2s
        t.stop();           // 给线程1打上打断标志
    }

}

class ThreadMonitor{

    private Thread monitor;

    // 启动线程，并执行while循环
    public void start(){
        monitor=new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                // 如果线程被打断，则执行后续操作之后退出
                if(current.isInterrupted()){
                    System.out.println("执行后续操作，然后退出...");
                    break;
                }
                // 线程没被打断，让线程睡眠0.5s
                try {
                    Thread.sleep(500);  // 线程1休眠
                    System.out.println("执行监控记录...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt(); // 重新设置打断标记。因为在sleep中被打断，会重置打断标志为false
                }
            }
        },"线程1");
        monitor.start();
    }

    // 停止线程
    public void stop(){
        monitor.interrupt();
    }

}
