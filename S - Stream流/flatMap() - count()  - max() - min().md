

### flatMap的使用

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

### 使用

```jshelllanguage
import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();

        User u1 = new User("小1", 21,Arrays.asList("a1","a2","a3"));
        User u2 = new User("小2", 22,Arrays.asList("a2","a3","a4"));
        User u3 = new User("小3", 23,Arrays.asList("a3","a4","a5"));
        User u4 = new User("小4", 24,Arrays.asList("a4","a5","a6"));
        User u5 = new User("小5", 25,Arrays.asList("a5","a6","a7"));

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        
        // flatMap() : 计算所有书本的数量，并去重
        // 分析 ： n个对象，有m本书，其中有重复的书名 ，不可使用.map()
        long count = list.stream()
                .flatMap(user -> user.getBooks().stream())  // 获取到对象的list集合的所有元素，并转为流对象
                .distinct()                                 // 去重
                .count();                                   // 计算数目
        
        System.out.println("书本数目 = "+count);

        // max() : 求出所有user中年龄最大的数字
        Optional<Integer> max = list.stream()
                .map(user -> user.getAge())
                .max((age1, age2) -> age1 - age2);
        System.out.println(max.get());

        // min() : 求出所有user中年龄最小的数字
        Optional<Integer> min = list.stream()
                .map(user -> user.getAge())
                .min((age1, age2) -> age1 - age2);
        System.out.println(min.get());
        
    }
}

```