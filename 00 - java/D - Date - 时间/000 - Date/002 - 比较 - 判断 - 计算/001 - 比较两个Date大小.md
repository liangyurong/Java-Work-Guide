## 两个Date日期是否相等

使用getTim,而不是使用date1==date2

```java
import java.util.Date;

public class TestDate {
    
     public static void main(String[] args) {
        // date1 比 date2 晚五分钟 
        System.out.println(compareDate(new Date("Fri Dec 24 10:40:35 CST 2021"),new Date("Fri Dec 24 10:35:35 CST 2021")));
     }

    /**
     * date1  比 date2 大 ：true （ date1是2021 ，date2是2020 ）
     * date1  比 date2 小 ：false
     */
    public static boolean compareDate(Date date1, Date date2) {

       boolean flag =  date1.getTime() > date2.getTime();

       return flag;
    }

}
```















