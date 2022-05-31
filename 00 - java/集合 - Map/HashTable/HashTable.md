#### 基础

- 基于hash表实现

- HashTable线程安全，但是使用了synchronized对方法进行了加锁，在读写数据的时候都进行了加锁，在插入数据的时候不能进行读取数据。

- 当在多线程环境下，所有线程都要去竞争同一把锁，效率非常低

- HashTable遇到null的时候会抛出NullPointerException

```jshelllanguage
  public synchronized V put(K key, V value) {
     // 如果value为null，抛出NullPointerException
     if (value == null) {
        throw new NullPointerException();
     }
     // 如果key为null，在调用key.hashCode()时抛出NullPointerException
  }
```

- HashTable成员变量

```jshelllanguage
  //table是Entry[]数组类型，Entry是一个单向链表。哈希表的"key-value键值对"都是存储在Entry数组中。 
  private transient Entry[] table;  
  // Hashtable中元素的实际数量  
  private transient int count;  
  // 阈值，用于判断是否需要调整Hashtable的容量（threshold = 容量*加载因子）  
  private int threshold;  
  // 加载因子  
  private float loadFactor;  
  // Hashtable被改变的次数  
  private transient int modCount = 0;  
```

- modCount

  **modCount**指的是HashTable被修改或者删除的次数总数。用来实现“fail-fast”机制的（也就是快速失败）。所谓快速失败就是在并发集合中，其进行迭代操作时，若有其他线程对其进行结构性的修改，这时迭代器会立马感知到，并且立即抛出ConcurrentModificationException异常，而不是等到迭代完成之后才告诉你