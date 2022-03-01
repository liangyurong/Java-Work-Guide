
```java
import java.util.Calendar;
import java.util.Date;
public class TestDate {

  public static void main(String[] args) {
      Integer i = yearsBetween(new Date("Thu Apr 22 00:00:00 CST 2021"),new Date("Thu Apr 01 00:00:00 CST 2021"));
      System.out.println(i);
  }

    /**
     * 计算两个日期之间相差的年数
     * input :  new Date("Thu Apr 01 00:00:00 CST 2021") , new Date("Thu Apr 22 00:00:00 CST 2023")
     * output:  2
     * @param smallDate 较小的时间
     * @param bigDate   较大的时间
     * @return 相差的年数
     */
    public static Integer yearsBetween(Date smallDate, Date bigDate) {

        Calendar small = Calendar.getInstance();
        small.setTime(smallDate);

        Calendar big = Calendar.getInstance();
        big.setTime(bigDate);

        // 为防止大小日期输入的位置不对，因此添加一个判断，保证能够输出一个非负数
        int result = big.get(Calendar.YEAR) - small.get(Calendar.YEAR);

        return result >= 0 ? result : -result;
    }

}
```
