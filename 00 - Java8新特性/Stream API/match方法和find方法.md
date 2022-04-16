## match

anyMatch:   任意一个符合条件就返回true，否则false

allMatch:   全部符合条件就返回true，否则false

noneMatch:  全部都不符合条件返回true，否则false

### find

findAny：    获取一个满足条件的任意元素，不保证是第一个

findFirst：  获取一个满足条件的任意元素，保证是第一个

### code

```jshelllanguage
import java.util.*;
import java.util.stream.Collectors;

    public class Test {
        public static void main(String[] args) {

            List<User> list = new ArrayList<>();

            User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
            User u2 = new User("小2", 22,Arrays.asList("a2","a3","a4"));
            User u3 = new User("小3", 23,Arrays.asList("a3","a4","a5"));
            User u4 = new User("小4", 24,Arrays.asList("a4","a5","a6"));
            User u5 = new User("小5", 25,Arrays.asList("a5","a6","a7"));
            User u6 = new User("小3", 23,Arrays.asList("a3","a4","a5")); // 与u3是同一个对象

            list.add(u1);
            list.add(u2);
            list.add(u3);
            list.add(u4);
            list.add(u5);
            list.add(u6);


            // anyMatch 任意一个符合条件就返回true，否则false
            boolean b = list.stream()
                    .anyMatch(user -> user.getAge() > 29);
            System.out.println(b);

            // allMatch 全部符合条件就返回true，否则false
            boolean b1 = list.stream()
                    .allMatch(user -> user.getAge() > 23);
            System.out.println(b1);


            // noneMatch 全部都不符合条件返回true，否则false
            boolean b2 = list.stream()
                    .noneMatch(user -> user.getAge() > 30);
            System.out.println(b2);

            // findAny 获取一个满足条件的任意元素，不保证是第一个
            Optional<User> en1 = list.stream()
                    .filter(user -> user.getAge() > 21)
                    .findAny();
            en1.ifPresent(user-> System.out.println(user.getName())); // 存在就输出名字，不存在就不输出

            // findFirst 获取一个满足条件的任意元素，保证是第一个
            Optional<User> en2 = list.stream()
                    .filter(user -> user.getAge() > 21)
                    .findFirst();
            en2.ifPresent(user-> System.out.println(user.getName())); // 存在就输出名字，不存在就不输出

        }

    }

```

### user

```jshelllanguage
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;
    private List<String> books;

    @Override
    public String toString() {
        return this.getName()+" "+this.getAge()+" "+this.getBooks();
    }

}

```