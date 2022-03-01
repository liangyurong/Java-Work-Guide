

### 一、使用map接收Post过来的两个参数

- 请求的URL：lcoalhost:8080/getUser?name=yurong&password=123456

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @PostMapping("/getUser")
    @ResponseBody
    public Map getUser(@RequestParam String name,@RequestParam String password){
        Map map=new HashMap();
        map.put("name",name);
        map.put("password",password);
        return map;
    }

}
```

### 二、使用对象接收Post过来的参数

- 参数需要对应实体类的成员变量。

- 请求的URL：lcoalhost:8080/getUser?name=yurong&password=123456

```java
import com.lyr.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @PostMapping("/getUser")
    @ResponseBody
    public Map getUser(User user){
        Map map=new HashMap();
        map.put("name",user.getName());
        map.put("password",user.getPassword());
        return map;
    }
}
```

User.java

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String password;
}
```