
### 1、字符串存储在final修饰的字符数组中

```text
private final char value[];
```

### 2、String类中 的equals方法被重写

使用String.equals()方法是比较内容，而不是内存地址。

### 3、String中equals方法源码

```java
public class Test{
        public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            // anObject是否是String类型
            if (anObject instanceof String) {
                String anotherString = (String)anObject;
                int n = value.length;
                if (n == anotherString.value.length) {
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) {
                        if (v1[i] != v2[i]){
                            return false;
                        }
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }
}
```

比较两个字符串，因为String和StringBuffer的类型不匹配，后面的字符串都没必要去比较了
```java
public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer("abc");
        StringBuffer s3 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));//false
        System.out.println(s3.equals(s1));//false
    }
}
```













