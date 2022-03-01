
```java
import org.junit.Test;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import java.util.Date;

public class TestDate {

  @Test
  public void test() {
      String dateStr1 = "2017-03-01 22:33:23";
      Date date1 = DateUtil.parse(dateStr1);

      String dateStr2 = "2017-03-21 23:33:23";
      Date date2 = DateUtil.parse(dateStr2);

      //相差一个月，20天
      long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
      System.out.println(betweenDay);
  }

}
```
