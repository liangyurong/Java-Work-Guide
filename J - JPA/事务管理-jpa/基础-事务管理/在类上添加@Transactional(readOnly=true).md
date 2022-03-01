


## 待解决：在类上添加@Transactional(readOnly = true, rollbackFor = Exception.class)


### 为什么要这么做？会导致什么？


### 能读，也能save

类上添加了： @Transactional(readOnly = true, rollbackFor = Exception.class)

方法添加了： @Transactional(readOnly = false, rollbackFor = Exception.class)

结果：并没有只读，还是能够save新的对象到数据库。

原因是什么？因为是方法上的注解的作用力更强

```java
import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao pDao;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void selectPeopleById(String id){
        System.out.println(pDao.findPeopleById(id).toString());
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void savePeople() {
        People p = new People();
        p.setName("name333");
        pDao.save(p);
    }
}
```

### 只能只读，不能save

操作：只在类上添加事务注解，不在方法上添加注解

```java
package com.lyr.demo.service.impl;

import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao pDao;

    @Override
    public void selectPeopleById(String id){
        System.out.println(pDao.findPeopleById(id).toString());
    }

    @Override
    public void savePeople() {
        People p = new People();
        p.setName("name333");
        pDao.save(p);
    }
}
```
