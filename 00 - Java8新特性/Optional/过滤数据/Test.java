import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Optional<User> optionalUser = getUser();

        // 不符合条件，返回一个空的Optional对象
        Optional<User> user1 = optionalUser.filter(user -> user.getAge() > 23);
        user1.ifPresent(user -> System.out.println(user));

        // 符合条件，返回Optional对象
        Optional<User> user2 = optionalUser.filter(user -> user.getAge() > 18);
        user2.ifPresent(user -> System.out.println(user));


    }

    // 建立User对象
    // 一定要使用ofNullable()返回Optional对象，不要直接 return null
    public static  Optional<User> getUser(){
        User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
        // return Optional.ofNullable(null);
        return Optional.ofNullable(u1);
    }


}
