
### StringBuilder,StringBuffer

StringBuilder线程不安全，StringBuffer线程安全。

查看源码，发现两者的区别在于append方法有没有添加锁，也就是synchronized关键字。

### StringBuilder的append

```java
@Override
public StringBuilder append(String str) {
   super.append(str);
   return this;
}
```

### StringBuffer的append

```java
@Override
public synchronized StringBuffer append(String str) {
   toStringCache = null;
   super.append(str);
   return this;
}
```




















