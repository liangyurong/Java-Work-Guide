import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Optional<User> optionalUser = getUserOptional();

        // orElseGet：如果optionalUser里面的对象是null，则可以自己设置一个返回的默认值，这里设置为返回一个空的User对象
        User user = optionalUser.orElseGet(() -> new User());
        System.out.println(user);

    }

    // 建立User对象
    // 一定要使用ofNullable()返回Optional对象，不要直接 return null
    public static  Optional<User> getUserOptional(){
        User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
        // Optional.ofNullable(null)
        return Optional.ofNullable(u1);
    }


}
