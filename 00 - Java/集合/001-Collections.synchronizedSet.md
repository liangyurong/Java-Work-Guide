

### Collections.synchronizedSet()

java.util.Collections类的synchronizedSet()方法用于返回由指定集合支持的同步(线程安全)集合 

### 简单使用示例

该例子没什么卵用

```java
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("TP");
        set.add("IS");
        set.add("FOR");
        set.add("TECHIES");
        System.out.println("本来的set："+set);
        Set<String> synset = Collections.synchronizedSet(set);
        System.out.println("Synchronized set is :"+synset);
    }

}
```
