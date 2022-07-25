## join基础


### join()

在main线程中执行A.join()（等A线程运行结束）

    Thread A = new Thread

A.join(long n) 等待线程运行结束，最多等待n毫秒

    如果n毫秒过后，即使A线程仍在运行，但是main线程就不会再等待了（假如只有A线程和main线程）

join方法，主要用于两个线程之间的通信