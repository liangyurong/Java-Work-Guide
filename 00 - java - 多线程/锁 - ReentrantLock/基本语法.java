import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        // 获取锁
        reentrantLock.lock();
        try{
            // 临界区

        }finally {
            // 释放锁
            reentrantLock.unlock();
        }
    }

}