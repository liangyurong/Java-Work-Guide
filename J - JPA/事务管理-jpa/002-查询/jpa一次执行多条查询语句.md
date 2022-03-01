
### @Transactional(readOnly = true, rollbackFor = Exception.class)

只读，保证数据一致性。

如果有写操作，不会写成功，也不会报异常。

### 一次执行多条查询语句

一次执行多条查询语句，多条查询SQL必须保证整体的读一致性。

否则，在前条SQL查询之后，后条SQL查询之前，数据被其他用户改变，则该次整体的统计查询将会出现读数据不一致的状态，此时，应该启用事务支持。

注意
```txt
是一次执行多次查询来统计某些信息，这时为了保证数据整体的一致性，要用只读事务
```

### 示例

说明
```txt
当执行方法时，打印出第一条结果，进入休眠，手动在mysql修改字段的值，当休眠结束，打印的还是没修改的值。readOnly = true保证了数据的一致性。
```
打印结果如下：
```text
People(id=1, name=name1, myEmail=1, address=1)
People(id=1, name=name1, myEmail=1, address=1)
```

在第一次方法执行结束后，再次执行方法，休眠期间不进行任何操作，会打印修改后的值。这很正常，因为已经是一次新的读取操作了。、
```text
打印结果如下：
People(id=1, name=name2223, myEmail=1, address=1)
People(id=1, name=name2223, myEmail=1, address=1)
```


```java
package com.lyr.demo.service.impl;

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

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public void selectPeopleById(String id) throws InterruptedException {
         System.out.println(pDao.findById(id).get().toString());
         sleep(10000); // 睡眠10s
         System.out.println(pDao.findById(id).get().toString()); // 休眠期间手动修改字段的值，打印的还是修改前的值。不会显示修改后的值。
    }

}

```
