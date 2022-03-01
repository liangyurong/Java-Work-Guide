
```java
package com.sdyb.mp.test.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.Test;
import java.util.Date;

public class TestConvert {

  @Test
  public void test() {

      String a = "2017-05-06";
      Date dateA = Convert.toDate(a);

      String a1 = "2017-05-06 10:01:20";
      Date dateA1 = Convert.toDate(a1);

      // 时:分:秒 不可以这么写
      String a2 = "2017-05-06 10-01-20";
      Date dateA2 = Convert.toDate(a2); // null

// ---------------------------------------------------------------------

      String b = "2021/12/12";
      Date dateB = Convert.toDate(b);

      String b1 = "2021/12/12 10:01:20";
      Date dateB1 = Convert.toDate(b1);

      // 时:分:秒 不可以这么写
      String b2 = "2017/05/06 10/01/20";
      Date dateB2 = Convert.toDate(b2); // null

      System.out.println(dateB2);
  }
}

```
