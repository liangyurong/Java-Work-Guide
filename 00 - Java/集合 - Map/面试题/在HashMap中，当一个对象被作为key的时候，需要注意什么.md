## 在HashMap中，当一个对象被作为key的时候，需要注意什么？

做法：HashMap存储一个自定义对象当做key的时候，一定要重写equals()方法和hashCode()方法。不能只重写其中一个。

当HashMap调用put()或者get()，需要将值（key）对应的哈希码与数组中的哈希码比较，如果相等时，则会通过equals方法比较key值是否相等。

如果HashCode与equals()方法都得出true，则两个key相等。如果有其中一个方法返回false，则两个key不相等。

#### 问题2：重写equals()方法，为什么还要重写hashCode()方法？

Object类中的hashCode()：本地方法，返回一个int类型的哈希值。根据对象的内存地址算出来的一个整数。

重写hashCode()方法，就是为了减少哈希冲突。使用Objects.hash()方法可以有效减少冲突。
