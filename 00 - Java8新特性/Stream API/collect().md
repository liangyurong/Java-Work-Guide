### collect

把当前的流转为一个集合

转为List集合： collect(Collectors.toList());

转为set集合：  

转为map集合：


### Code

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


        // 转为List集合 : 年龄>22的集合 (23 24 25 23)
        list.stream()
                .map(user -> user.getAge())    // 只拿出年龄
                .filter(age -> age > 22)       // age>22
                .collect(Collectors.toList())  // 转为List
                .forEach(System.out::println);

        // 转为Set集合 : 年龄>22的集合 (23 24 25)
        list.stream()
                .map(user -> user.getAge())
                .filter(age -> age > 22)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        
        // 转为Map集合 ： key为name ， value为age
        Map<String, Integer> map =
                list.stream()
                    .distinct()   // 排除重复key。User类需要添加注解@EqualsAndHashCode，否则报错Duplicate key 23
                    .collect(Collectors.toMap(User::getName, User::getAge));
        // 输出map
        Set<Map.Entry<String, Integer>> es = map.entrySet();
        for(Map.Entry entry: es) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
    
}

```


### User

```jshelllanguage
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode // 可对User去重
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