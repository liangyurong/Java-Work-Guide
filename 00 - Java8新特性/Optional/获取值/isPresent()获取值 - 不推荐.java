import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Optional<User> optionalUser = getUserOptional();

        // isPresent：判断是否为空再决定是否输出
        // 步骤繁琐，还不如直接使用null判断
        if(optionalUser.isPresent()){
            User entity = optionalUser.get();
            System.out.println(entity);
        }

    }

    // 建立User对象
    // 一定要使用ofNullable()返回Optional对象，不要直接 return null
    public static  Optional<User> getUserOptional(){
        User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
        // Optional.ofNullable(null)
        return Optional.ofNullable(u1);
    }


}
