
buffer用于和channel通道进行交互。

数据是从通道读入缓冲区，从缓冲区写入通道

缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装为NIO Buffer对象

NIO Buffer对象实际上是一个容器对象，更直接说，就是一个数组。在NIO库中，所有的数据都是用缓冲区处理的。


