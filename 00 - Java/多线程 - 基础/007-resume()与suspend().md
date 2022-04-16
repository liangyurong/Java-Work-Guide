### 基础

resume：恢复

suspend：暂停

resume()：恢复暂停的线程。当线程A执行suspend()方法后会被挂起，当线程A执行resume()方法可使得线程A重新获取CPU时间片。

suspend()：暂停线程，线程将会被挂起。如果该线程占有了锁，则它不会释放锁。也就是，线程在挂起的状态还持有锁。

suspend()与resume()方法的缺点：独占。使用不当极易造成公共的同步对象的独占，使得其他线程无法访问公共同步对象。

代码分析：线程命名为A，先start()，再suspend()，之后线程命名为B，然后resume()。

代码结果：先循环输出A。main休眠一秒后，循环输出B。说明了线程被挂起之后是可以恢复的。
```java
 public class Solution {
    public static void main(String[] args) throws InterruptedException {
        MyThread ta=new MyThread();
        ta.setName("A");
        ta.start();
        Thread.sleep(1000); //main线程休眠1s，让线程A可以执行
        ta.suspend();
        ta.setName("B");
        Thread.sleep(1000);
        ta.resume();
    }
 }

 class MyThread extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName());
        }
    }
 }
```

