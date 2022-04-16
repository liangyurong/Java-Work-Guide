### 一、线程基础

Thread.currentThread()：返回执行当前代码指令的线程引用

this关键字指向的是当前对象的引用

this.getName是当前实例对象的线程名称。

### 二、将线程对象以构造参数的方式传递给Thread对象进行start()启动，和直接使用线程对象进行start()启动，是不一样的

```java
TestThread t = new TestThread();
t.start();

Thread t1 = new Thread(t);
t1.start();
```

不一样的地方
```java
见下面的代码
```

### 三、代码一：创建一个线程t1，传入对象t,使用t1.start()

```java
public class Test {
    public static void main(String[] args) {
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);
        t1.setName("a");
        t1.start();
    }
}
class TestThread extends Thread {
    /**
     * 想要证明 this 是当前的TestThread实例对象t，其实可以使用this.i来输出一下i的值，间接证明
     */
    int i=0;

    TestThread(){
        //false，Thread.currentThread是main线程，this是TestThread线程。是main线程来执行new TestThread()方法
        System.out.println(Thread.currentThread() == this);
        
        //Thread.currentThread()代表的是主线程main
        System.out.println("currentThreadName = "+Thread.currentThread().getName());
        
        //this代表的是当前的TestThread实例对象t，系统自动为其命名为thread-0
        System.out.println("this.getName() = "+this.getName());
        
        //Thread-0线程没有启动，所以是false
        System.out.println("this.isAlive()="+this.isAlive());
     
    }

    @Override
    public void run() {
        //false ， main线程!=this线程
        System.out.println(Thread.currentThread() == this);
        
        //Thread.currentThread()代表的是线程a，此时thread-0线程被命名为a
        System.out.println("currentThreadName = "+Thread.currentThread().getName());
        
        //this代表的是当前的TestThread实例对象t，系统自动为其命名为thread-0
        System.out.println("this.getName() = "+this.getName());
        
        //Thread-0线程没有启动，所以是false
        System.out.println("this.isAlive()="+this.isAlive());
    }
}
```

### 四、代码二：直接使用t.start()
```java
public class Test {
    public static void main(String[] args) {
        TestThread t = new TestThread();
        t.setName("a");
        t.start();
    }
}

class TestThread extends Thread {
    /**
     * 想要证明 this 是当前的TestThread实例对象t，其实可以使用this.i来输出一下i的值，间接证明
     */
    int i=0;

    TestThread(){
        //false ， main线程！=TestThread线程
        System.out.println(Thread.currentThread() == this);
        
        //Thread.currentThread()代表的是主线程main
        System.out.println("currentThreadName = "+Thread.currentThread().getName());
        
        //this代表的是当前的TestThread实例对象t，系统自动为其命名为thread-0，因为还没有给这个线程赋值为“a”
        System.out.println("this.getName() = "+this.getName());
        
        //Thread-0线程没有启动，所以是false
        System.out.println("this.isAlive()="+this.isAlive());
        
    }

    @Override
    public void run() {  //Thread.currentThread().getName()指的是调用run方法的线程是哪个
        //true
        System.out.println(Thread.currentThread() == this);
        
        //Thread.currentThread()代表的是线程a
        System.out.println("currentThreadName = "+Thread.currentThread().getName());
        
        //this代表的是当前的TestThread实例对象t，系统自动为其线程命名为thread-0,这边程序将线程名称改为a
        System.out.println("this.getName() = "+this.getName());//a
        
        //线程a启动，所以是true
        System.out.println("this.isAlive()="+this.isAlive());
        
    }
}
```
