
## 评价

2021-10。这次使用的自定义注解虽然成功了，但是要使用反射来获取变量，很麻烦。暂时不知道更好的做法


## 自定义注解类

```jshelllanguage
import java.lang.annotation.*;

@Target(ElementType.FIELD) // 
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
```

## 实体类

实体类的fruitName使用自定义注解，添加默认值

```jshelllanguage
import com.lyr.writetosee.annotation.FruitName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {

    @FruitName(value = "大西瓜滴滴滴")
    private String fruitName;

}
```

## controller，获取fruitName

```jshelllanguage
import com.lyr.writetosee.annotation.FruitName;
import com.lyr.writetosee.entity.Fruit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
public class TestController {
    
    @GetMapping("/hi")
    public String sayHi()  {
        // 反射
        Class<Fruit> clazz = Fruit.class;
        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            // 如果变量中含有@FruitName的注解
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                String value = fruitName.value();
                return value;
            }
        }
        return "null val";
    }

}
```
