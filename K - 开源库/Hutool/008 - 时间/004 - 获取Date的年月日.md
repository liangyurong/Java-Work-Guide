
```java
import org.junit.Test;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class TestDate {

  @Test
  public void test() {
    // 当前时间，Date类型
    Date date = DateUtil.date();

    // 获得年的部分
    int year = DateUtil.year(date);

    // 获得月份，从0开始计数。所以12月份返回11
    int month = DateUtil.month(date);

    // 获取日，从1开始计数
    int day = DateUtil.dayOfMonth(date);
  }
  
}
```  
