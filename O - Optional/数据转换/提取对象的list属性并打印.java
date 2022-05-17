import java.util.*;

public class Test {
    public static void main(String[] args) {

        Optional<User> optionalUser = getUserOptional();

        // 将User对象中的books属性提取出来并打印
        Optional<List<String>> optionalBooks = optionalUser.map(user -> user.getBooks());
        optionalBooks.ifPresent(books -> System.out.println(books));

        // 返回空的Optional对象
        Optional<User> nullUser = getNullUserOptional();

        // 无打印输出
        Optional<List<String>> nullBooks = nullUser.map(user -> user.getBooks());
        nullBooks.ifPresent(books -> System.out.println(books));

    }

    // 建立User对象
    // 一定要使用ofNullable()返回Optional对象，不要直接 return null
    public static  Optional<User> getUserOptional(){
        User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
        // Optional.ofNullable(null)
        return Optional.ofNullable(u1);
    }

    // 返回空的Optional对象
    public static  Optional<User> getNullUserOptional(){
        return Optional.ofNullable(null);
    }


}
