
### 添加的pom依赖

```xml
        <!-- https://mvnrepository.com/artifact/commons-beanutils/commons-beanutils -->
        <dependency>
            <groupId>commons-beanutils</groupId>
            <artifactId>commons-beanutils</artifactId>
            <version>1.9.3</version>
        </dependency>
```

### 拷贝

2021-12-22，是深拷贝

使用：int num = System.identityHashCode(Object);

### 复制

```java
import com.sdyb.mp.dto.StudentDto;
import com.sdyb.mp.entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/copy")
public class TestCopy {

  @GetMapping("testCopy3")
  public String testCopy3() throws InvocationTargetException, IllegalAccessException {
    
    // 源头  
    Student source = new Student("id1", "name1", "email1");
    
    // 目标
    StudentDto target = new StudentDto();
    
    // 目标在左 源在右
    BeanUtils.copyProperties(target,source);
    
    return target.getName()+" "+target.getMyEmail();
  }

}
```
