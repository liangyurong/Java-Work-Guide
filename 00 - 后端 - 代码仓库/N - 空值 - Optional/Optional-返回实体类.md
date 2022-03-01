
### dao层

```java
package com.lyr.demo.dao;

import com.lyr.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<People,String> {

    @Query(value = "select * from people where id = ?1",nativeQuery = true)
    People findPeopleById(String id);
    
}
```

### 测试类

```java
package com.lyr.demo.controller;

import com.lyr.demo.dao.PeopleDao;
import com.lyr.demo.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
public class Test {

    @Autowired
    private PeopleDao pDao;

    /**
     * 不推荐。他人可能直接调用并默认不会返回null
     */
    @GetMapping("/findPeopleById")
    @ResponseBody
    public People findPeopleById(@RequestParam("id")String id){
      // 找得到，返回实体类
      // 找不到，返回null
      return pDao.findPeopleById(id);
    }

    /**
     * 推荐，能够直接提醒他人，这里的接口可能返回null
     */
    @GetMapping("/getOptionalById")
    @ResponseBody
    public Optional<People> getOptionalById(@RequestParam("id")String id){
        // 找得到，返回实体类
        // 找不到，返回null
        return Optional.ofNullable(pDao.findPeopleById(id));
    }

}
```
