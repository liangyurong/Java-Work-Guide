### 一、==

对于非基础数据类型，比较的是内存地址

要比较两个基本数据类型的变量或者两个引用变量（引用变量，不是对象）是否相等，只能用==进行比较

什么是引用变量？引用变量指向的是对象（引用类型），例如String c=new String(“hello”);，变量c占用一块存储空间，c对应的内存中存储的就是对象“hello”占用那块内存的首地址。

对于指向对象的变量，要比较两个变量是否指向同一个对象，只需要比较两个变量所对应的内存中的地址是否一样，使用==即可

要比较两个变量指向的对象的内容是否相同，使用String类的equals


```java
public class Test {
    public static void main(String[] args) {
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println(s1==s2); // false , 内存地址不一样
        System.out.println(s1.equals(s2)); // true ， 内容一样
    }
}
```



### 二、equals



```java
public class Main {
    public static void main(String[] args) {
        String str = "";
        String str1 = " ";
        String[] array = new String[2];
        System.out.println(str.length()); // 0
        System.out.println(str1.length()); // 1
        System.out.println(array.length); // 2
    }
}
```
