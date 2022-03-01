## @Transactional

可以放在类上，也可以放在方法上

### service层什么时候使用@Transactional？

不需要：一个方法只有一个查询，没有其他数据库的操作。

需要添加：一个方法中有多个查询

需要添加：jpa要求更新、删除和插入操作必须有事务支持，也就是加上注解@Transactional。没有事务不能正常执行。

需要添加：一个方法中既有查询，也有其他数据库的操作

说明：
```java
public class xxxServiceImpl{
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void xxxMethos() {
        // 第1种情况： 单个插入；多个插入
        // 第2种情况： 单个更新；多个更新
        // 第3种情况： 单个删除；多个删除
        // 第4种情况： 有插入也有其他操作      
    }
}
```

### 单个select操作不需要加注解@Transactional，两条及其以上需要加上

```java
public class xxxServiceImpl{
    @Override
    public void xxxMethos() {
        // 第1种情况： 单个select    
        pDao.findById(id).get(); 
    }
}
```

### 说明：多个select，设置为只读

```java
public class xxxServiceImpl{
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public void xxxMethos() {
        // 第1种情况： 多个select      
    }
}
```

### 多个select，在只读情况下，休眠期间手动修改字段的值，打印的还是修改前的值。不会显示修改后的值

```java
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public void selectPeopleById(String id) throws InterruptedException {
         System.out.println(pDao.findById(id).get().toString());
         sleep(10000); // 睡眠10s
         System.out.println(pDao.findById(id).get().toString()); // 休眠期间手动修改字段的值，打印的还是修改前的值。不会显示修改后的值。
    }
```

### service层调用dao层的sql语句

情况1：service只调用 **1** 个sql语句，且sql语句没有@Transactional，那么service上不添加注解@Transactional

情况2：service只调用 **1** 个sql语句，且sql语句上有@Transactional，那么在service上添加注解
> @Transactional(readOnly = false, rollbackFor = Exception.class)

情况3：service只调用 **多** 个sql语句，则一定添加注解@Transactional（增删改查混合）
> @Transactional(readOnly = false, rollbackFor = Exception.class)

情况4：service只调用 **多** 个sql语句，则一定添加注解@Transactional（多个select的sql）
> @Transactional(readOnly = true, rollbackFor = Exception.class)

### @Transactional(readOnly = true, rollbackFor = Exception.class)

在方法上使用这个，当前方法的事务是只读。

如果进行事务的其他操作，比如保存是不行的。

备注：readOnly = true写在A方法，那么就只影响A方法，是不能影响到B方法的。（比如B方法的是readOnly = false）

```java
import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao pDao;

    /**
    *  因为事务是只读，所以这两个save操作都不能进行。
    */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public void savePeople() {
        People p = new People();
        p.setName("name1111");

        pDao.save(p);

        People p1 = new People();
        p1.setName("name2222");
        pDao.save(p1);

    }

}
```

### @Transactional(readOnly = false, rollbackFor = Exception.class)

默认是readOnly = false，因此等同于@Transactional(rollbackFor = Exception.class)


