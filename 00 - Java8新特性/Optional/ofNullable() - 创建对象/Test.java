import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Optional<User> optionalUser = getUser();

        optionalUser.ifPresent(user -> System.out.println(user.toString()));

    }

    // 建立User对象
    // 一定要使用ofNullable()返回Optional对象，不要直接 return null
    public static  Optional<User> getUser(){
        User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
        return Optional.ofNullable(u1);
    }

}
