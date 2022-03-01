
待解决

### 返回一个实体类



### 测试例子

```java
public class Test{

        @Autowired
        private PeopleDao pDao;
    
        @GetMapping("/test")
        @ResponseBody
        public String testa(@RequestParam("id")String id){
            Optional<People> entity = pDao.findPeopleById(id);
            //.isPresent()一般与.get()方法合用，当entity不为空时，optional.isPresent()值为true，通过get（）方法返回对象。
            if(entity.isPresent()){
                return entity.get().getId(); // 返回对象的id
            }else {
                return "根据id找不到对象"; // 我觉得这里需要改进，难道直接改为 return null ?
            }
        }
}
```

### dao层

```java
package com.lyr.demo.dao;

import com.lyr.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleDao extends JpaRepository<People,String> {

    Optional<People> findPeopleById(String id);

}

```

### 实体类

```java
package com.lyr.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people") //对应mysql的表名
public class People {
    @Id // 主键
    @GenericGenerator(name = "idGenerator", strategy = "uuid") // id采用uuid生成
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="my_email")
    private String myEmail;

    @Column(name="address")
    private String address;
}

```
