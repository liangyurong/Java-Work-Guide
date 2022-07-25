## ConcurrentHashMap为什么不允许插入null

有什么结果？

    运行期间报错：空指针异常

在源码方法里

    if(key==null || value==null) throw new NullPointerException();

设计初衷

    杜绝二义性问题

    假如允许插入null，在多线程情况下，A线程执行concurrenthashmap.get(key)，当key不存在，因此期望返回的是null

    但在返回之前，B线程执行了concurrenthashmap.put(key,null)，此时A线程返回的结果还是null

    那么会出现一个二义性问题：是该key不存在返回null？还是说key对应的value是null？

hashmap为什么允许插入null？

    因为hashmap是在单线程下使用的，可以使用containsKey()方法来解决二义性问题