### User

不需要实现接口

```jshelllanguage
public class User {

    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
}
```

### 排序

关键：sorted((u1,u2)-> u1.getAge()-u2.getAge())



```jshelllanguage
import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();

        list.add(new User("小3",23));
        list.add(new User("小5",25));
        list.add(new User("小4",24));
        list.add(new User("小1",21));
        list.add(new User("小2",22));
        
        // 升序排序
        list.stream().sorted((u1,u2)-> u1.getAge()-u2.getAge()).forEach(user -> System.out.println(user.getName()+" : "+ user.getAge()));
        // 等同 list.stream().sorted(Comparator.comparingInt(User::getAge)).forEach(user -> System.out.println(user.getName()+" : "+ user.getAge()));
        
        // 降序排序
        // list.stream().sorted((u1,u2)-> u2.getAge()-u1.getAge()).forEach(user -> System.out.println(user.getName()+" : "+ user.getAge()));

    }
}
```