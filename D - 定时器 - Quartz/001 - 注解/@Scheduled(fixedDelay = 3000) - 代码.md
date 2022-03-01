


```jshelllanguage
package com.sdyb.aiyimei.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PrintJob {

    // Thread.sleep: 设置任务的执行时间是5s
    // fixedDelay = 3000：上一个任务结束之后，过3s，执行下一个任务
    @Scheduled(fixedDelay = 3000)
    public void print(){
       System.out.println("hello run --> "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello end --> "+new Date());
    }

}

```

## 执行结果

```txt
hello run --> 23:47:20 CST 2021
hello end --> 23:47:25 CST 2021
// 间隔3s执行下一个任务
hello run --> 23:47:28 CST 2021
hello end --> 23:47:33 CST 2021

hello run --> 23:47:36 CST 2021
hello end --> 23:47:41 CST 2021

hello run --> 23:47:44 CST 2021
hello end --> 23:47:49 CST 2021
```
