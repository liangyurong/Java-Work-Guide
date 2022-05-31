
```java
import java.util.Calendar;
import java.util.Date;
public class TestDate {

  public static void main(String[] args) {
      Integer i = daysBetween(new Date("Thu Apr 22 00:00:00 CST 2021"),new Date("Thu Apr 01 00:00:00 CST 2021"));
      System.out.println(i);
  }

    /**
     * 计算两个日期之间相差的天数
     * input : new Date("Thu Apr 01 00:00:00 CST 2021") , new Date("Thu Apr 22 00:00:00 CST 2021")
     * output : 21
     * @param smallDate 较小的时间
     * @param bigDate   较大的时间
     * @return 相差天数
     */
    public static Integer daysBetween(Date smallDate, Date bigDate) {
        Calendar cal = Calendar.getInstance();
        
        cal.setTime(smallDate);
        long time1 = cal.getTimeInMillis();
        
        cal.setTime(bigDate);
        long time2 = cal.getTimeInMillis();
        
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
        
        // 为防止大小日期输入的位置不对，因此添加一个判断，保证能够输出一个非负数
        betweenDays = betweenDays >=0 ? betweenDays : -betweenDays;
        
        return Integer.parseInt(String.valueOf(betweenDays));
    }

}
```
