
### 获取list

```java
package com.lyr.demo.controller;

import com.lyr.demo.entity.People;
import com.lyr.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
public class PeopleController {

  @Autowired private EntityManager em;

  @GetMapping("/tt")
  public List<People> tt() {
    String sql = "select * from people where name = '1' ";
    Query nativeQuery = em.createNativeQuery(sql);
    List<People> list = nativeQuery.getResultList();
    return list;
  }
}

```
