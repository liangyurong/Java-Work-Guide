### 为什么java类要实现序列化


### 原因



### 实现序列化的类

```jshelllanguage
public class Dept implements Serializable {
}
```

### 什么是序列化

序列化是指把对象转换为字节序列的过程，我们称之为对象的序列化，就是把内存中的这些对象变成一连串的字节(bytes)描述的过程。

而反序列化则相反，就是把持久化的字节文件数据恢复为对象的过程。

### 什么时候需要序列化

### 什么是Serializable接口

Serializable是java.io包中定义的、用于实现Java类的序列化操作而提供的一个语义级别的接口。一个类只有实现了Serializable接口，它的对象才能被序列化。









