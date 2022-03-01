

```java
package com.sdyb.mp.module.student;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudent {

  public static void main(String[] args) {

    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    // 管道：筛选元素
    List<Integer> newList = list.stream().filter(base -> base == 1).collect(Collectors.toList());
    newList.forEach(System.out::println);

  }
}

```
