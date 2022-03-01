
### 源码

```java
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

  public static void main(String[] args) {
      System.out.println(new Date());
      String s = date2String(new Date());
      System.out.println(string2Date(s));
  }

    /**
     * 将String类型的日期转换为Date类型日期
     * input: 2021-04-02 00:00:00
     * output: Fri Apr 02 00:00:00 CST 2021
     */
    public static Date string2Date(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将Date类型日期的日期转换为String类型
     * inout: Fri Apr 02 00:00:00 CST 2021
     * output: 2021-04-02 00:00:00
     * 备注：使用 DateFormat 类来规定时间格式和解析日期字符串。Date 中的相应方法已废弃
     */
    public static String date2String(Date date) {
        // 规定时间格式  1、yyyy-MM-dd 2、yyyy-MM-dd hh:mm:ss
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // Date转String
        String dateStr = df.format(date);
        // 返回
        return dateStr;
    }

}

```
