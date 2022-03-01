### 知识

JPA默认情况下和MyBatis一样开启一级缓存

### 异常情况：即使不加注解，两次查询还是会得到相同的结果

背景：JPA+mysql

操作：在休眠期间，手动修改表的字段值，但是第二次输出的结果还是和第一次一样，不知道是什么回事。

### 原因猜测

jpa缓存问题？（是这个原因）

mysql缓存问题？(不是这个问题)

### 原因分析

由于JPA的一级缓存问题，即使没有加@Transactional，因为查询的是同一个id，所以去缓存查询了。

### 解决

在application.properties关闭就jpa的一级缓存
```properties
spring.jpa.open-in-view=false 
```

### 源码

```java
import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.lang.Thread.sleep;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao pDao;

    // @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void selectPeopleById(String id) throws InterruptedException {
         System.out.println(pDao.findPeopleById(id).toString());
         sleep(10000); // 休眠之后手动更改某个字段的值
         System.out.println(pDao.findPeopleById(id).toString()); // 返回的还是未修改的值
    }
}
```
