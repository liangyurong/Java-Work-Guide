
```java
package com.sdyb.mp.test.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.Test;

import java.util.List;

public class TestConvert {

  @Test
  public void test() {

    // object数组 转 List
    Object[] a = {"a", "你", "好", "", 1};
    List<?> list = Convert.toList(a);

    // int数组 转 List
    int[] a1 = {1, 2, 3, 4, 5, 6};
    List<?> list1 = Convert.toList(a1);

    // Integer数组 转 List
    Integer[] a2 = {6, 5, 4, 4, 5, 6};
    List<?> list2 = Convert.toList(a2);

    // double数组，long数组也可以转List

    // double数组 转 List
    double[] a3 = {0.06, 0.05, 0.04, 0.04, 0.05, 0.06};
    List<?> list3 = Convert.toList(a3);

    list3.forEach(
        base -> {
          System.out.println(base);
        });
  }
}

```
