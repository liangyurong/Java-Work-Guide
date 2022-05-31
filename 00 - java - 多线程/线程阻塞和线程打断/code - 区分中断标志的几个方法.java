public class Test {
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{},"t1");
        t1.start();
        t1.interrupt();                          // 对t1线程打上中断标志
        System.out.println(t1.isInterrupted());  // true
        System.out.println(Thread.currentThread().isInterrupted()); // main线程没被打上中断标志，因此返回false
    }
}