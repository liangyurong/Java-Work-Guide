## @Scheduled(fixedRate = 3000)



### 源码

```jshelllanguage
package com.sdyb.aiyimei.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PrintJob {

    // Thread.sleep: 设置任务的执行时间是5s
    // @Scheduled(fixedRate = 3000)：单线程条件下，间隔3s执行一个任务，如果3s之后前一个任务没执行完，下一个任务会阻塞。当前一个任务执行完，则下一个任务会立刻执行
    @Scheduled(fixedRate = 3000)
    public void print(){
       System.out.println("hello run --> "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello end --> "+new Date());
        System.out.println();
    }
}
```

### 结果

hello run --> Sun Nov 21 23:54:01 CST 2021
hello end --> Sun Nov 21 23:54:06 CST 2021
// 阻塞的下一个任务会在前一个任务执行后立即执行
hello run --> Sun Nov 21 23:54:06 CST 2021
hello end --> Sun Nov 21 23:54:11 CST 2021

hello run --> Sun Nov 21 23:54:11 CST 2021
hello end --> Sun Nov 21 23:54:16 CST 2021

hello run --> Sun Nov 21 23:54:16 CST 2021
