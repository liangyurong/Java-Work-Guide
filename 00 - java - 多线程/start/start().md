## start()基础

让线程进入就绪，里面的代码并不一定立刻执行，需要获取到cpu时间片才能执行

每个线程对象的start方法只能调用一次，如果调用多次会出现IllegalThreadStateException

