


### 源代码

```java
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked") // 需要忽略编译器警告
@RestController
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/get")
    public List get() {
        String sql = "select * from student where name =  ?";
        Query query = entityManager.createNativeQuery(sql); // 执行sql原生语句
        query.setParameter(1,"1"); // sql语句的第1个参数
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); // 设置查询结果返回map对象
        return query.getResultList(); // 返回的是一个List<Object[]>。也就是说每行的数据被作为一个对象数组返回
    }
}

```

### 不使用@SuppressWarnings("unchecked")，编译过程可能会出错

可能，存在一定概率会出错。

### 运行结果

```text
[
    {
        "name": "1",
        "my_email": "11",
        "id": "1"
    },
    {
        "name": "1",
        "my_email": "as@qq.com",
        "id": "1415193629223333890"
    },
    {
        "name": "1",
        "my_email": "hhhh@qq.com",
        "id": "4"
    }
]
```

### 不使用query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 

则直接返回结果，不是map类型

```text
[
    [
        "1",
        "1",
        "11"
    ],
    [
        "1415193629223333890",
        "1",
        "as@qq.com"
    ],
    [
        "4",
        "1",
        "hhhh@qq.com"
    ]
]
```
