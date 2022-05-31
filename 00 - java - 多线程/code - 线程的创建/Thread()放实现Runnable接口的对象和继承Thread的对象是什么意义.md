## Thread()放实现Runnable接口的对象和继承Thread的对象是什么意义？

将实现Runnable接口的类看做是任务类，重写的run方法就是任务。

任务如果是需要放在多线程中执行，那就需要Thread类。

创建一个Thread类，将任务类对象作为参数传递给Thread的构造方法，调用Thread类的start方法就会启动一个线程，它会导致任务类的run方法执行，当run方法执行完毕，线程终止。
