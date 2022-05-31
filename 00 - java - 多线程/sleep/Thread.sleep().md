## Thread.sleep()

让当前的线程释放CPU资源，不释放锁。

当前的线程指的是：Thread.currentThread()返回的线程。也就是执行Thread.sleep()这段代码的线程。

```jshelllanguage
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    // t1线程休眠1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // main线程休眠1s
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
```