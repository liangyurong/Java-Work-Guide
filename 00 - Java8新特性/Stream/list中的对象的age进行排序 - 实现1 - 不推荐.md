### User对象

需要实现接口Comparable

```jshelllanguage
public class User implements Comparable<User> {

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

    @Override
    public int compareTo(User obj) {
        return this.getAge() - obj.getAge();
    }
    
}
```

### 排序

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
        list.stream().sorted().forEach(user -> System.out.println(user.getName()+" : "+ user.getAge()));

        // 降序排序
        // 只需要在User类的compareTo方法中改变两个相减的参数
        
    }
}
```