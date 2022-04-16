#### 关键数值

- LoadFactor：负载因子，默认是0.75
- threshold：所能容纳的键值对的数量，计算公式为：数组长度*负载因子
- transient int size：HashMap中实际存储的键值对数量
- transient int modCount：记录HashMap内部结构发生变化的次数
- HashMap默认容量INITIAL_CAPACITY是16，也就是1<<4

#### 基础

- 连接：https://zhuanlan.zhihu.com/p/125628540
- JDK1.8中，HashMap的结构是数组+链表+红黑树
- HashMap数组部分叫哈希桶。
- 在JDK1.8中，当HashMap的链表长度>=8的时候，链表数据转变为红黑树。当长度变为6的时候转为链表
- 哈希桶扩容之后，所有的数值需要重新计算放置的下标
- HashMap采用Entry数组来存储key-value键值对，每一个键值对组成了一个Entry实体。
- Entry类实际上是一个单向的链表结构，它具有next指针，可以连接下一个Entry实体
- HashMap内部的节点是无顺序的
- 有序的map有：LinkedHashMap和TreeMap



问题

1. HashMap是怎么进行扩容的？

   

#### HashMap是怎么存储数据的

对于一组key-value数据，通过哈希函数hash(key)得到value在哈希桶的下标。

如果几组数据的hashcode相同，就会调用equals方法来比较value的异同。相同的就会覆盖之前的value，不同的话就会在后面添加一个数据。（这也是链表的存在理由）

#### HashMap的哈希函数怎么设计

JDK1.8中的设计

```java
/**
* hash函数是先拿到通过key 的hashcode，是32位的int值，然后让hashcode的高16位和低16位进行异或操作
*/
static final int hash(Object key) {
   int h;
   return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

**为什么需要设计这么一个哈希函数**

1. 该函数也叫做扰动函数，设计的原因有两个；
2. 一是为了尽可能得降低hash碰撞，越分散越好
3. 二是算法需要尽可能高效，因为这是高频操作，因此采用的是位运算。

**为什么采用hashcode的高16位和低16位异或能降低hash碰撞？hash函数能不能直接用key的hashcode？**

1. 因为key.hashCode()函数调用的是key键值类型自带的哈希函数，返回int型散列值。int值范围为**-2147483648~2147483647**，前后加起来大概40亿的映射空间。只要哈希函数映射得比较均匀松散，一般应用是很难出现碰撞的。但问题是一个40亿长度的数组，内存是放不下的。你想，如果HashMap数组的初始大小才16，用之前需要对数组的长度取模运算，得到的余数才能用来访问数组下标。

#### HashMap怎么设定初始容量大小

如果自己传入初始大小cap，初始化大小为 大于cap的 2的整数次方；例如如果传10，大小为16

算法实现过程：算法就是让初始二进制右移1，2，4，8，16位，分别与自己异或，把高位第一个为1的数通过不断右移，把高位为1的后面全变为1

```java
/**
 * Returns a power of two size for the given target capacity.
 */
static final int tableSizeFor(int cap) {
   int n = cap - 1;
   n |= n >>> 1;
   n |= n >>> 2;
   n |= n >>> 4;
   n |= n >>> 8;
   n |= n >>> 16;
   return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```



#### HashMap的底层实现原理

#### JDK1.7与1.8的区别，做了哪些改进？为什么？因为什么问题才改进的？

JDK1.7存储结构：数组+链表。多线程环境下容易造成死锁。

JDK1.8存储结构：数组+链表+红黑树

1. 数组+链表改成了数组+链表或红黑树；
2. 链表的插入方式从头插法改成了尾插法，简单说就是插入时，如果数组位置上已经有元素，1.7将新元素放到数组中，原始节点作为新节点的后继节点，1.8遍历链表，将元素放置到链表的最后；
3. 扩容的时候1.7需要对原数组中的元素进行重新hash定位在新数组的位置，1.8采用更简单的判断逻辑，位置不变或索引+旧容量大小；
4. 在插入时，1.7先判断是否需要扩容，再插入，1.8先进行插入，插入完成再判断是否需要扩容；

#### 为什么JDK1.8要做这些优化

1. 防止发生hash冲突，链表长度过长，将时间复杂度由`O(n)`降为`O(logn)`;
2. 因为1.7头插法扩容时，头插法会使链表发生反转，多线程环境下会产生环；
   A线程在插入节点B，B线程也在插入，遇到容量不够开始扩容，重新hash，放置元素，采用头插法，后遍历到的B节点放入了头部，这样形成了环，如下图所示：

#### CurrentHashMap与HashMap底层的实现差异

#### HashMap的默认容量？什么是时候进行扩容？大小为什么是2 的幂？

#### 哈希表中的数组可以使用LinkedList代替吗？

可以，但是时间复杂度较高

#### 在并发场景下，ConcurrentHashMap是怎么保证线程安全的？又是怎么实现高性能读写的？

#### ConcurrentHashMap的分段锁的实现原理

ConcurrentHashMap成员变量使用volatile 修饰，免除了指令重排序，同时保证内存可见性，另外使用CAS操作和synchronized结合实现赋值操作，多线程操作只会锁住当前操作索引的节点。

#### 避免HashMap的线程问题

Java中有HashTable、Collections.synchronizedMap、以及ConcurrentHashMap可以实现线程安全的Map。

改用HashTable或者Collections.synchronizedMap。但是这两者，对于读写操作都会对整个集合进行加锁，因此同一时间的其他操作都会阻塞。

HashTable是直接在操作方法上加synchronized关键字，锁住整个数组，粒度比较大，

Collections.synchronizedMap是使用Collections集合工具的内部类，通过传入Map封装出一个SynchronizedMap对象，内部定义了一个对象锁，方法内通过对象锁实现

ConcurrentHashMap使用分段锁，降低了锁粒度，让并发度大大提高。

#### 链表转红黑树是链表长度达到阈值，这个阈值是多少？

阈值是8，红黑树转链表阈值为6

#### 为什么是8，不是16，32甚至是7 ？又为什么红黑树转链表的阈值是6，不是8了呢？

因为经过计算，在hash函数设计合理的情况下，发生hash碰撞8次的几率为百万分之6。因为8够用了，至于为什么转回来是6，因为如果hash碰撞次数在8附近徘徊，会一直发生链表和红黑树的转化，为了预防这种情况的发生

#### LinkedHashMap怎么实现有序的？

LinkedHashMap内部维护了一个单链表，有头尾节点，同时LinkedHashMap节点Entry内部除了继承HashMap的Node属性，还有before 和 after用于标识前置节点和后置节点。可以实现按插入的顺序或访问顺序排序。

```jshelllanguage
/**
 * The head (eldest) of the doubly linked list.
 * transient 短暂的
*/
transient LinkedHashMap.Entry<K,V> head;

/**
  * The tail (youngest) of the doubly linked list.
*/
transient LinkedHashMap.Entry<K,V> tail;
//链接新加入的p节点到链表后端
private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
  LinkedHashMap.Entry<K,V> last = tail;
  tail = p;
  if (last == null)
    head = p;
  else {
    p.before = last;
    last.after = p;
  }
}
//LinkedHashMap的节点类
static class Entry<K,V> extends HashMap.Node<K,V> {
  Entry<K,V> before, after;
  Entry(int hash, K key, V value, Node<K,V> next) {
    super(hash, key, value, next);
  }
}
```



#### TreeMap怎么实现有序的？

TreeMap是按照Key的自然顺序或者Comprator的顺序进行排序，内部是通过红黑树来实现。所以要么key所属的类实现Comparable接口，或者自定义一个实现了Comparator接口的比较器，传给TreeMap用户key的比较。

#### 其他

1. 线程不安全，主要体现在哪里
   1. 在并发场景下存在数据丢失，数据重复，死循环
   2. 并发的时候扩容 resize可能会导致链表出现死循环
   3. rehash的时候，java1.7采用的是尾插法
2. 要不要看源码实现
3. HashMap对象的key、value值均可为null。HahTable对象的key、value值均不可为null。且两者的的key值均不能重复，若添加key相同的键值对，后面的value会自动覆盖前面的value，但不会报错。
4. 

