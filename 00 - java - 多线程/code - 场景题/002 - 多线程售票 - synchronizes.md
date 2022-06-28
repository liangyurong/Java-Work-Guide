### 需求

多个窗口同时卖100张票。

不同窗口不能买同一张票

### 为什么要sleep呢？不sleep就不行了吗？
    
线程不进行sleep是可以的，但因为计算机执行速度过快，同一个窗口一下子就把100张票卖完了，我们看不到多线程执行的效果，因此我们需要在执行的线程休眠让其他线程执行。

### 分析
    
多线程售票其实是一个典型的事例变量共享例子。

### 正确代码

让三条线程使用同一个Ticket对象，因此在Ticket类中的方法加上锁，这样子就可以实现线程同步了。

```java
public class Test {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        // 三条线程相当于三个窗口
        Thread t1 = new Thread(ticket,"窗口1");
        Thread t2 = new Thread(ticket,"窗口2");
        Thread t3 = new Thread(ticket,"窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}


class Ticket implements Runnable{

    private int count = 0;

    public Ticket(){}

    public void sale() {
        while (true){
            try {
                Thread.sleep(10);     // 防止一个窗口快速把票卖完
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){       // 锁定Ticket new出来的对象
                if(count<=99){
                    count++;
                    System.out.println(Thread.currentThread().getName()+ "：卖出 -> " + count);
                }else {
                    System.out.println(Thread.currentThread().getName()+": 已售完");
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        sale();
    }
}
```

### 错误代码

原因分析：多个窗口同时卖用一张票。明明已经对方法上锁了，为什么还是会卖出同一张票呢？

    三条线程，分别对应不同的Ticket对象，相当于三个窗口各自卖100张不同的票。比如1-100，101-200，201-300

```java
public class Solution {
    public static void main(String[] args) {
        Ticket t1=new Ticket();
        Ticket t2=new Ticket();
        Ticket t3=new Ticket();
        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket extends Thread{
    private int tic=1;
    @Override
    public synchronized void run() {
        while(tic<=100){
            System.out.println(currentThread().getName()+"卖出了第"+tic+"张票");
            tic++;
        }
    }
}
```

### 错误代码2

结果：所有票都被一个线程卖出，没有其他线程进行售票。

此刻的线程休眠都是多余的。

原因：因为锁在while外面，所以第一个线程上锁之后，一直到它把所有票卖完，其它线程都无法获取锁。所以要实现分散卖票，锁必须在while的内部。

```java
public class Solution {
    public static void main(String[] args) {
        Ticket T = new Ticket();
        Thread t1 = new Thread(T);
        Thread t2 = new Thread(T);
        Thread t3 = new Thread(T);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket extends Thread {
    private int tic = 1;
    @Override
    public void run() {
        synchronized (this) {
            while (tic <= 100) { //上锁了，同一个窗口没卖完票都出不去。
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tic + "张票");
                tic++;
            }
        }
    }
}
```

### 错误代码2的改进程序，仍有错误

结果：虽然已经有不同的窗口卖票，但是出现超卖现象。因此，while(tic<=99)必须在锁的里面。

超卖的原因：可能A线程执行到while(tic<=99)的时候，另一个线程B也执行到while(tic<=99)，当线程B卖完了第100张票。线程A会继续执行卖到第101张。

```java
public class Solution {
    public static void main(String[] args) {
        Ticket T = new Ticket();
        Thread t1 = new Thread(T);
        Thread t2 = new Thread(T);
        Thread t3 = new Thread(T);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket extends Thread {

    private int tic = 0;

    @Override
    public void run() {
        while (tic <= 99) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                tic++;
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tic + "张票");

            }
        }
    }
}
```

### 错误代码2的改进程序，无错误

```java
public class Solution {
    public static void main(String[] args) {
        Ticket T = new Ticket();
        Thread t1 = new Thread(T);
        Thread t2 = new Thread(T);
        Thread t3 = new Thread(T);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket extends Thread {

    private int tic = 0;

    @Override
    public void run() {
        while (true) {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if(tic<=99){
                    tic++;
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + tic + "张票");
                }else {
                    return;
                }

            }
        }
    }
}
```


