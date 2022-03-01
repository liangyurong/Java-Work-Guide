
### @Transactional(readOnly = false, rollbackFor = Exception.class)

如果存在两个关于数据库的操作，要么同时成功，要么同时失败，不可能出现一个成功一个失败的情况。

也就是说，在service层调用dao层的方法上要添加注解@Transactional

### controller层

```java
package com.lyr.demo.controller;

import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @Autowired
    private PeopleService pService;

    @GetMapping("/insertEntity")
    @ResponseBody
    public void findPeopleById(){
         pService.savePeople();
    }
    
}
```

### impl层

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

    // 加上@Transactional(rollbackFor = Exception.class)，则两个save的数据库操作，要么同时成功，要么同时失败，不可能出现一个成功一个失败的情况。
    // 默认就是 readOnly = false, 因此可以只写@Transactional(rollbackFor = Exception.class)
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class) // 没有readOnly=false
    public void savePeople() {
        People p = new People();
        p.setName("name1111");

        pDao.save(p);
        int i = 1/0; // 此处会抛异常：java.lang.ArithmeticException: / by zero

        p.setName("name2222");
        pDao.save(p);

    }
}
```

### seivice层

```java
package com.lyr.demo.service;

public interface PeopleService {
    void savePeople();
}
```

### dao层

```java
package com.lyr.demo.dao;

import com.lyr.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<People,String> {

}

```
























