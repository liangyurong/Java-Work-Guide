### 时间戳和Date互转

时间戳一般是long类型的数值

```jshelllanguage
        Timestamp timestamp = new Timestamp();
        long time = timestamp.getTime();
```

### 源码

```java
import java.util.Date;
import java.sql.Timestamp;
public class TestDate {

  public static void main(String[] args) {
      long l = date2Timestamp(new Date());
      System.out.println(timestamp2Date(l));
  }

    /**
     * 时间戳转字符串
     */
    public static Date timestamp2Date(long timestamp) {

        Date date =  new Date(timestamp);

        return date;
    }

    /**
     * 字符串转时间戳
     */
    public static long date2Timestamp(Date date) {

        long time = date.getTime();

        Timestamp timestamp = new Timestamp(time);

        long time1 = timestamp.getTime();

        return time1;
    }

}
```


