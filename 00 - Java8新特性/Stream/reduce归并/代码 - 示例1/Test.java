import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
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

        // 使用reduce求所有user的年龄总和
        Integer sum = list.stream()
                .map(User::getAge)
                .reduce(0, (age1, age2) -> age1 + age2); // 初始值是0，后面是操作
        // 等同于 .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);


        // 第一种方法：使用reduce求所有user中的年龄最小值
        Integer minVal = list.stream()
                .map(User::getAge)
                .reduce(Integer.MAX_VALUE, (age1, age2) -> age1<age2? age1:age2);
        System.out.println("minVal = " + minVal);

        // 第二种方法：使用reduce求所有user中的年龄最小值
        Optional<Integer> minVal1 = list.stream()
                .map(User::getAge)
                .reduce((age1, age2) -> age1<age2? age1:age2);
        minVal1.ifPresent(min -> System.out.println(min));
        System.out.println("minVal1 = " + minVal1);

    }

}
