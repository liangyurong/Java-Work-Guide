### 基础

equals()方法返回true的话，hashCode()方法也应该返回true。倒转过来未必。

equals()方法重写的话，那么hashCode()方法也要重写。

只有设计哈希表操作的才需要重写equals()的同时再重写hashCode()方法。如果自定义对象是放入list中，自然就没有必要重写hashCode()方法。

对于哈希结构的东西，它们判断元素重复是先判断哈希值然后再判断equals()的。也就是说先判断哈希值，如果哈希值相等，内容不一定等，此时继续判断equals()。如果哈希值不等，那么此时内容一定不等，就不用再判断equals()了，直接操作。


## 在HashMap中，当一个对象被作为key的时候，需要注意什么？

做法：HashMap存储一个自定义对象当做key的时候，一定要重写equals()方法和hashCode()方法。不能只重写其中一个。

当HashMap调用put()或者get()，需要将值（key）对应的哈希码与数组中的哈希码比较，如果相等时，则会通过equals方法比较key值是否相等。

如果HashCode与equals()方法都得出true，则两个key相等。如果有其中一个方法返回false，则两个key不相等。

#### 问题1：不重写equals()会出现什么问题？

前提：当我们定义两个对象，我们不想根据对象的内存地址进行判断，而是根据对象的属性进行判断。如果两个对象的所有属性相同，那么我们认为两个对象是相同的。

因为new出来的两个对象，内存地址肯定是不同的。

在用HashMap的时候，如果不重写equals()方法，那么调用的是Object的equals()方法，自然就得出两个对象的内存地址是不同的，因此返回false。

#### 问题2：重写equals()方法，为什么还要重写hashCode()方法？

Object类中的hashCode()：本地方法，返回一个int类型的哈希值。根据对象的内存地址算出来的一个整数。
```text
public native int hashCode();
```

重写hashCode()方法，就是为了减少哈希冲突。使用Objejcts.hash()方法可以有效减少冲突。

难道本地的hashCode()方法就会有更多的哈希冲突吗？
