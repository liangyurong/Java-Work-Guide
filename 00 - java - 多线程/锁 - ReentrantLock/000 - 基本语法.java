import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        // 获取锁(拿到锁就返回，拿不到就等待，因此有可能产生死锁)
        reentrantLock.lock();
        try{
            // 临界区

        }finally {
            // 释放锁
            reentrantLock.unlock();
        }
    }

}