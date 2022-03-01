
### 一、基础

String类中使用final修饰字符数组来保存字符串，也就是private final char value[]，所以String 对象是不可变的；

StringBuilder 与 StringBuffer 都继承自 AbstractStringBuilder 类，在 AbstractStringBuilder 中也是使用字符数组保存字符串char[]value。（JDK 9 以后是 byte数组） 但是没有用 final 关键字修饰，所以这两种对象都是可变的。

### 二、线程安全性

String 中的对象是不可变的，也就可以理解为常量，线程安全。

AbstractStringBuilder 是 StringBuilder 与 StringBuffer 的公共父类，定义了一些字符串的基本操作，如 expandCapacity、append、insert、indexOf 等公共方法。

StringBuffer对append方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。

StringBuilder并没有对append方法进行加同步锁，所以是非线程安全的。

帮助记忆：Builder，不得，不得安全，所以是非线性安全。

### 三、性能

每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象。

StringBuffer 每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。

### 四、对于三者使用的总结

操作少量的数据: 适用String

单线程操作字符串缓冲区下操作大量数据: 适用StringBuilder

多线程操作字符串缓冲区下操作大量数据: 适用StringBuffer

### 五、为什么会出现StringBuilder，StringBuffer

String是不可变类，每次对String进行操作都会产生新的对象，在进行多次字符串操作的情况下容易产生内存浪费

StringBuffer是线程安全的。适用于多线程。

StringBuilder是非线程安全的。适用于单线程。

### 六、为什么需要String类型

安全
- 当String对象被多线程共享并频繁访问，可以保证数据的一致性
- String经常会被用来当做参数（比如数据库的用户名，密码之类，读写的文件），如果是可变量，黑客可能通过某种手段来对这些字符串进行修改造成安全隐患。（黑客怎么搞？举个具体的例子）

性能
- 我们在使用HashMap的时候，常常会使用String类型来作为key。因为String类是不可变的，只需要计算一次HashCode，后续可以直接取出来。
- 在HashMap内部，是通过key的HashCode来确定Value的存储位置，因此比其他的方式更快。

节省空间
- 在java语言中，为了提供效率和空间使用率，将字符串常量存储到常量池中，这些字符串可以被共享。因此，为了保证一个用户对字符串的修改不能影响到其他用户的使用，String被设计为不可变量。

















