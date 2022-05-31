## Thread和Runnable的区别

Thread也是实现了Runnable接口

直接采用Thread类建立任务，会让线程和任务耦合

实现Runnable接口，能够让线程对象和任务进行分离，能够更容易与线程池等高级API配合 （java也非常推荐组合优先于继承）