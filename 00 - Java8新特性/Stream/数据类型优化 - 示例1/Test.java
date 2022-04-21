import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
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

        // .map()中的操作，实际是有时间损耗的
        // 损耗分析：先将Integer拆箱成int，进行+10的操作，再装箱回Integer
        list.stream()
                .map(user -> user.getAge())
                .map(age -> age+10)
                .forEach(System.out::println);

        // 优化
        list.stream()
                .mapToInt(user -> user.getAge()) // 关键点
                .map(age -> age+10)
                .forEach(System.out::println);



    }

}