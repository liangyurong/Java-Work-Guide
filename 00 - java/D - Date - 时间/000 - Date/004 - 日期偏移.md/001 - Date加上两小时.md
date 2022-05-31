## Date加上两小时

在当前日期加上两小时
```jshelllanguage
import java.util.Calendar;
import java.util.Date;
public Date towHoursLater(){
    
    Date now = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    c.add(Calendar.HOUR_OF_DAY, 2);
    Date newDate = c.getTime();
    
    return newDate;
}

```








