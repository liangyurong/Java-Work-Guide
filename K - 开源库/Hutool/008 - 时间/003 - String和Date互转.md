
```java
import cn.hutool.core.date.DateUtil;
import org.junit.Test;
import java.util.Date;

public class TestDate {

    @Test
    public void test(){

        // 字符串转Date
        String dateStr = "2017-03-01 10:13:12";
        Date date = DateUtil.parse(dateStr);

        // 字符串转Date，规定格式
        String dateStr1 = "2017-03-01";
        Date date1 = DateUtil.parse(dateStr1, "yyyy-MM-dd");

        // Date转字符串 , 输出：2021-12-24
        Date date2 = new Date();
        String strDate = DateUtil.formatDate(date2);

    }

}
```
