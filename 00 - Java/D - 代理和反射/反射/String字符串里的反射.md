### String字符串里的反射

问题：为什么在类里面写了String str = "abc";之后，就能够使用str调用toLowerCase()方法？

分析

    内部使用了反射机制。定义了str字符串，那么内部就会把String字节码文件加载进内存

    在内存中，有一个class类对象，然后该对象把String类所有的方法抽取出来并封装到Method[] methods数组里面

```jshelllanguage
public class ReflectTest {
    public static void main(String[] args) {
        
        String str = "abc";
        str.toLowerCase();

    }

}
```