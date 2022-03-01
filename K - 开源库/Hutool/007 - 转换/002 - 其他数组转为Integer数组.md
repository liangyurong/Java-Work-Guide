

```java
package com.sdyb.mp.test.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.Test;

public class TestConvert {

  @Test
  public void test() {

    String[] b = {"1", "2", "3", "4"};
    // 结果为Integer数组
    Integer[] intArray = Convert.toIntArray(b);

    long[] c = {1, 2, 3, 4, 5};
    // 结果为Integer数组
    Integer[] intArray2 = Convert.toIntArray(c);

  }
}

```




















