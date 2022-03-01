
## @Builder的作用

用于数据传输

### 实体类

```java
import lombok.Builder;
import lombok.Data;

/**
* 用于传输数据
* 
* 不需要@Entity，@Table，因为不需要连接到数据库
* 
* 不需要无参注解和全参注解
* 
*/
@Data
@Builder
public class PeopleData {

    private String id;

    private String name;

    private String myEmail;

    private String address;
}
```

### controller示例

```java
import com.lyr.demo.entity.PeopleData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        // 构建实体类
        PeopleData entity = PeopleData.builder()
                .id("1")
                .name("yurong333")
                .myEmail("xxx@qq.com")
                .address("szu")
                .build();
        return entity.toString();
    }

}
```

