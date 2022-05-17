import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();

        User u1 = new User("小1", 21, Arrays.asList("a1", "a2", "a3"));
        User u2 = new User("小2", 22, Arrays.asList("a2", "a3", "a4"));
        User u3 = new User("小3", 23, Arrays.asList("a3", "a4", "a5"));
        User u4 = new User("小4", 24, Arrays.asList("a4", "a5", "a6"));
        User u5 = new User("小5", 25, Arrays.asList("a5", "a6", "a7"));
        User u6 = new User("小3", 23, Arrays.asList("a3", "a4", "a5")); // 与u3是同一个对象

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);

        // Predicate的写法太麻烦了，而且删除(Predicate<User>)会报错
        list.stream()
                .filter(
                        ((Predicate<User>) user -> user.getAge() < 22)
                    .or((Predicate<User>)user -> user.getAge() > 24)
                )
                .forEach(user -> System.out.println(user));

        // 上面的例子不如直接这么写
        list.stream()
                .filter(user -> user.getAge()<22 || user.getAge() > 24)
                .forEach(user -> System.out.println(user));


    }

}