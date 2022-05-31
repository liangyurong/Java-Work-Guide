## isInterrupted()和interrupted()

interrupt()

    Thread t1 = new Thread(()->{},"线程t1"); t1.interrupt();

    在线程打上一个停止的标志，并不是立刻停止线程。还需要加上一个判断才完成线程的停止。

    举例子线程A，Thread A=new Thread()。A.interrupt()：给线程A打上中断状态。

isInterrupted() 

    Thread t1 = new Thread(()->{},"线程t1"); t1.interrupt(); sout(t1.isInterruptes())

    返回true、false

    判断当前线程是否被打断，不会清除打断标志

interrupted()

    Thread.interrupted()

    返回true、false

    判断当前线程是否被打断，会清除打断标志，将标志设置为false