
### 一、通过Builder模式构建一个对象

字段初始值都是为空的，创建对象的时候才会赋值

```java
import lombok.Builder;

@Builder
public class Student {

    private String id;
    private String name;

    public static void main(String[] args) {
        // 创建对象
        Student s= Student.builder().id("123").name("yurong").build();
        System.out.println(s.id+" "+s.name);
    }

}
```

### 二、通过Builder模式构建一个对象，设定id初始值

```java
import lombok.Builder;
import java.util.UUID;

@Builder
public class Student {
    @Builder.Default // 不加此注解，则id不能生成
    private String id = UUID.randomUUID().toString();
    private String name;

    public static void main(String[] args) {
        // 创建对象
        Student s= Student.builder().name("yurong").build();
        System.out.println(s.id+" "+s.name);
    }

}
```


