

### code

```java
package com.sdyb.mp.module.student;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudent {

  public static void main(String[] args) {

    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(3);
    list.add(2);
    list.add(3);
    list.add(4);

    // 管道：筛选>1的元素
    List<Integer> newList = 
            list.stream()                   // 将集合转换成流
             .distinct()                    // 去重       
             .filter(base -> base > 1)      // 过滤 
             .collect(Collectors.toList()); // 转回List集合
    
    newList.forEach(System.out::println);

  }
}

```

结果

    2 3 4
