
### intern()

当调用某个字符串对象的intern方法时，就会去常量池中寻找，如果常量池中存在一个相同内容的字符串对象，则直接返回该对象的引用；

如果没有就将这个字符串添加到字符串池中，然会返回这个字符串的引用。

```java
public class Test {
    public static void main(String[] args) {
      String s1="ss";
      String s2=new String("ss");
      System.out.println(s1==s2); //false
      System.out.println(s1==s2.intern()); //true
    }
}
```
